package com.example.todaymovie.ui.movie.banner

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todaymovie.domain.model.Movie

class MovieBannerStateAdapter(fragment: Fragment, private val data: List<Movie>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return MovieBannerFragment.newInstance(data[position])
    }
}