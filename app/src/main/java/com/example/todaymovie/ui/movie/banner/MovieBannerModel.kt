package com.example.todaymovie.ui.movie.banner

import android.view.View
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.todaymovie.R
import com.example.todaymovie.domain.model.Movie

open class MovieBannerModel: EpoxyModelWithHolder<MovieBannerModel.Holder>() {
    @EpoxyAttribute
    var movies: List<Movie>? =null

    @EpoxyAttribute
    var fragment: Fragment? = null

    private var currentPosition = 0

    override fun getDefaultLayout(): Int {
        return  R.layout.item_media_home_banner
    }

    override fun bind(holder: Holder) {
        holder.viewPager?.let {
            it.offscreenPageLimit = 2
            if(fragment!=null && movies !=null) {
                it.adapter = MovieBannerStateAdapter(fragment!!, movies!!)
                it.setCurrentItem(currentPosition, false)
                it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        currentPosition = position
                    }
                })
            }
        }
    }

    override fun createNewHolder(parent: ViewParent): Holder {
        return Holder()
    }

     class Holder: EpoxyHolder() {
        var viewPager: ViewPager2? = null

        override fun bindView(itemView: View) {
            viewPager = itemView.findViewById(R.id.viewPager_movieBanner)

        }
    }

}