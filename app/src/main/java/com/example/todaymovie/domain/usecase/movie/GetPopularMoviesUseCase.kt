package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.repository.MovieRepository
import com.example.todaymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository): BaseUseCase<DomainResult<MovieResult>, Unit>() {

    override suspend fun execute(scope: CoroutineScope, params: Unit): DomainResult<MovieResult> {
        return repository.getPopularMovies()
    }
}