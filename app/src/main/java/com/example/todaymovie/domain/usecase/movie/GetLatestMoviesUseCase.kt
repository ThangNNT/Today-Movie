package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.repository.MovieRepository
import com.example.todaymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class GetLatestMoviesUseCase @Inject constructor(private val repository: MovieRepository): BaseUseCase<DomainResult<MovieResult>, Unit>()  {
    suspend fun getLatestMovie(): DomainResult<MovieResult>{
        return repository.getLatestMovies()
    }

    override suspend fun execute(scope: CoroutineScope, params: Unit): DomainResult<MovieResult> {
        return repository.getLatestMovies()
    }
}
