package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.data.repository.MovieRepository
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import javax.inject.Inject

class GetUpcomingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend fun getUpcomingMovies(): DomainResult<MovieResult> {
        return repository.getUpcomingMovies()
    }
}