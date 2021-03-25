package com.example.todaymovie.ui.tv.banner

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todaymovie.domain.model.TV

class TVBannerStateAdapter(fragment: Fragment, private val data: List<TV>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun createFragment(position: Int): Fragment {
        return TVBannerFragment.newInstance(data[position])
    }
}