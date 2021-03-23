package com.example.todaymovie.data.remote.datasource

import com.example.todaymovie.data.remote.MovieService
import com.example.todaymovie.data.remote.response.MovieResponse
import com.example.todaymovie.data.Result

import javax.inject.Inject


interface MovieRemoteDataSource{
    suspend fun getPopularMovies(): Result<MovieResponse>
    suspend fun getTrendingMovies(timeWindow: String): Result<MovieResponse>
    suspend fun getLatestMovies(): Result<MovieResponse>
    suspend fun getTopRatedMovies(): Result<MovieResponse>
    suspend fun getUpcomingMovies(): Result<MovieResponse>
    suspend fun getNowPlayingMovies(): Result<MovieResponse>
}

class MovieRemoteDataSourceImpl @Inject constructor(private val service: MovieService): MovieRemoteDataSource {

    override suspend fun getPopularMovies(): Result<MovieResponse> = getResult {
        return@getResult service.getPopularMovies()
    }

    override suspend fun getTrendingMovies(timeWindow: String) = getResult {
        return@getResult service.getTrendingMovies(timeWindow)
    }

    override suspend fun getLatestMovies() = getResult {
        return@getResult service.getLatestMovies()
    }

    override suspend fun getTopRatedMovies() = getResult {
        return@getResult service.getTopRatedMovies()
    }

    override suspend fun getUpcomingMovies() = getResult {
        return@getResult service.getUpcomingMovies()
    }

    override suspend fun getNowPlayingMovies() = getResult {
        return@getResult service.getNowPlayingMovies()
    }
}