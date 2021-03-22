package com.example.todaymovie.data.remote.datasource

import com.example.todaymovie.data.remote.MovieService
import com.example.todaymovie.data.remote.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val service: MovieService): BaseRemoteDataSource() {

    suspend fun getPopularMovies() = getResult {
        return@getResult service.getPopularMovies()
    }

    suspend fun getTrendingMovies(timeWindow: String) = getResult {
        return@getResult service.getTrendingMovies(timeWindow)
    }

    suspend fun getLatestMovies() = getResult {
        return@getResult service.getLatestMovies()
    }

    suspend fun getTopRatedMovies() = getResult {
        return@getResult service.getTopRatedMovies()
    }

    suspend fun getUpcomingMovies() = getResult {
        return@getResult service.getUpcomingMovies()
    }

    suspend fun getNowPlayingMovies() = getResult {
        return@getResult service.getNowPlayingMovies()
    }
}