package com.example.todaymovie.ui.tv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.example.todaymovie.R
import com.example.todaymovie.databinding.FragmentTvBinding
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TV
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TvFragment : Fragment() {

    private lateinit var binding: FragmentTvBinding
    private val tvViewModel: TvViewModel by viewModels()
    private var controller: TvController? =null
    private var skeletonScreen: SkeletonScreen? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        setupObserver()
    }

    private fun setup(){
        controller = TvController(this, ::onViewMoreClick, ::onItemClick)
        with(binding.rvTvs){
            adapter = controller?.adapter
        }
    }

    private fun setupSkeleton(){
        skeletonScreen = Skeleton.bind(binding.rvTvs)
                .adapter(binding.rvTvs.adapter)
                .count(1)
                .color(R.color.shimmer_color)
                .load(R.layout.item_home_skeleton)
                .show()
    }

    private fun setupObserver(){
        tvViewModel.tvHome.observe(viewLifecycleOwner){
            when(it.status){
                DomainResult.Status.LOADING ->{
                    setupSkeleton()
                }

                DomainResult.Status.SUCCESS ->{
                    skeletonScreen?.hide()
                    controller?.setData(it.data)

                }

                DomainResult.Status.ERROR ->{
                    Timber.e(it.error.toString())
                }
            }
        }
    }

    private fun onItemClick(tv: TV){

    }

    private fun onViewMoreClick(){

    }

    companion object {

    }
}