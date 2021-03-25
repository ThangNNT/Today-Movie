package com.example.todaymovie.ui.movie.banner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todaymovie.databinding.FragmentMovieBannerBinding
import com.example.todaymovie.domain.model.Movie


class MovieBannerFragment : Fragment() {

    private lateinit var binding: FragmentMovieBannerBinding

    private val movie: Movie? by lazy {
        arguments?.getParcelable(MOVIE)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBannerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.movie = movie
    }

    companion object {
        fun newInstance(movie: Movie): MovieBannerFragment{
            return MovieBannerFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE, movie)
                }
            }
        }
        private const val MOVIE = "MOVIE"
    }

}