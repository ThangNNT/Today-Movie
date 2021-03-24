package com.example.todaymovie.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todaymovie.databinding.FragmentMovieBinding
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by viewModels()
    private val controller = MovieController(::onViewMoreClick, ::onItemClick)


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
        setupObserver()
    }

    private fun setup(){
        with(binding.rvMovies){
            setController(controller)
        }
    }

    private fun setupObserver(){
        movieViewModel.movieHome.observe(viewLifecycleOwner){
            when(it.status){
                DomainResult.Status.LOADING -> {
                    binding.loadingBar.visibility = View.VISIBLE
                }
                DomainResult.Status.SUCCESS -> {
                    binding.loadingBar.visibility = View.GONE
                    it.data?.let { movieHome ->
                        controller.setData(movieHome)
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