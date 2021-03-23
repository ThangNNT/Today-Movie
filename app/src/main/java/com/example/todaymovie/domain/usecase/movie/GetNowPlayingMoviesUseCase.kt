package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend fun getNowPlayingMovies(): DomainResult<MovieResult>{
        return repository.getNowPlayingMovies()
    }
}