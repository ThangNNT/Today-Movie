package com.example.todaymovie.domain.repository

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult

interface MovieRepository {
    suspend fun getPopularMovies(): DomainResult<MovieResult>

    suspend fun getTrendingMovies(timeWindow: String): DomainResult<MovieResult>

    suspend fun getLatestMovies(): DomainResult<MovieResult>

    suspend fun getTopRatedMovies(): DomainResult<MovieResult>

    suspend fun getUpcomingMovies(): DomainResult<MovieResult>

    suspend fun getNowPlayingMovies(): DomainResult<MovieResult>
}