package com.example.todaymovie.ui.tv.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todaymovie.databinding.FragmentTvBannerBinding
import com.example.todaymovie.domain.model.TV


class TVBannerFragment : Fragment() {

    private lateinit var binding: FragmentTvBannerBinding

    private val tv: TV? by lazy {
        arguments?.getParcelable(TV)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBannerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tv = tv
    }

    companion object {
        fun newInstance(tv: TV): TVBannerFragment{
            return TVBannerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(TV, tv)
                }
            }
        }
        private const val TV = "TV"
    }

}