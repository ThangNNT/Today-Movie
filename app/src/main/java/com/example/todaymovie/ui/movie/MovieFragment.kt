package com.example.todaymovie.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.todaymovie.R
import com.example.todaymovie.data.remote.MovieService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : Fragment() {
    @Inject
    lateinit var service: MovieService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            try {
                service.getPopularMovies()
            }
            catch (ex: Throwable){

            }
        }
    }

    companion object {

    }
}