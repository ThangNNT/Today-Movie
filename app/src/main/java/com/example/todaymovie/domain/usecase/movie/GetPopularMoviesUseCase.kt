package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.data.repository.MovieRepository
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend fun getPopularMovies(): DomainResult<MovieResult> {
        return repository.getPopularMovies()
    }
}