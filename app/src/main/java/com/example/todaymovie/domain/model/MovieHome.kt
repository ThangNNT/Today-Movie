package com.example.todaymovie.domain.model


data class MovieHome(
        val nowPlayingMovies: List<Movie>?,
        val popularMovies: List<Movie>?,
        val topRateMovies: List<Movie>?,
        val trendingMovies: List<Movie>?,
        val upcomingMovies: List<Movie>?
)