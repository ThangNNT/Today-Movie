package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.data.repository.MovieRepository
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend fun getTrendingMovies(): DomainResult<MovieResult> {
        return repository.getTrendingMovies(TRENDING_DAY)
    }
    companion object {
        private const val TRENDING_DAY = "day"
        private const val TRENDING_WEEK ="week"
    }
}