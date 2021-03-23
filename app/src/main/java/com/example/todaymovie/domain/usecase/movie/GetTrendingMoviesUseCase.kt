package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryGetTrendingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend fun getTrendingMovies(): DomainResult<MovieResult> {
        return repository.getTrendingMovies(TRENDING_DAY)
    }
    companion object {
        private const val TRENDING_DAY = "day"
        private const val TRENDING_WEEK ="week"
    }
}