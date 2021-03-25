package com.example.todaymovie.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.example.todaymovie.R
import com.example.todaymovie.databinding.FragmentMovieBinding
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.util.px
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private var controller: MovieController?= null
    private var skeletonScreen: SkeletonScreen? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        setupSkeleton()
        setupObserver()
    }

    private fun setup(){
        controller= MovieController(this, ::onViewMoreClick, ::onItemClick)
        controller?.let { controller->
            with(binding.rvMovies){
                setController(controller)
            }
        }
    }

    private fun setupSkeleton(){
        skeletonScreen = Skeleton.bind(binding.rvMovies)
                .adapter(binding.rvMovies.adapter)
                .count(1)
                .color(R.color.shimmer_color)
                .load(R.layout.item_home_skeleton)
                .show()
    }

    private fun setupObserver(){
        movieViewModel.movieHome.observe(viewLifecycleOwner){
            when(it.status){
                DomainResult.Status.LOADING -> {
                }
                DomainResult.Status.SUCCESS -> {
                    skeletonScreen?.hide()
                    binding.rvMovies.apply {
                        binding.rvMovies.setPadding(paddingLeft, paddingTop, paddingRight, 24.px)
                    }
                    it.data?.let { movieHome ->
                        controller?.setData(movieHome)
                    }
                }
                DomainResult.Status.ERROR -> {
                    Timber.e(it.toString())
                }
            }
        }
    }

    private fun onViewMoreClick(){

    }
    private fun onItemClick(movie: Movie){

    }
}