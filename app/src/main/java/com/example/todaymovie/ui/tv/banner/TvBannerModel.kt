package com.example.todaymovie.ui.tv.banner

import android.view.View
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.todaymovie.R
import com.example.todaymovie.domain.model.TV

open class TvBannerModel: EpoxyModelWithHolder<TvBannerModel.Holder>() {
    @EpoxyAttribute
    var tvs: List<TV>? =null

    @EpoxyAttribute
    var fragment: Fragment? = null

    private var currentPosition = 0

    override fun getDefaultLayout(): Int {
        return  R.layout.item_media_home_banner
    }

    override fun bind(holder: Holder) {
        holder.viewPager?.let {
            it.offscreenPageLimit = 2
            if(fragment!=null && tvs !=null) {
                it.adapter = TVBannerStateAdapter(fragment!!, tvs!!)
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