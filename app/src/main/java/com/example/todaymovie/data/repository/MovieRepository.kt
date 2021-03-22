package com.example.todaymovie.data.repository

import com.example.todaymovie.data.Result
import com.example.todaymovie.data.remote.datasource.MovieRemoteDataSource
import com.example.todaymovie.data.remote.mapper.MovieMapper
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieRemoteDataSource: MovieRemoteDataSource, private val movieMapper: MovieMapper): BaseRepository() {

    suspend fun getPopularMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getPopularMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    suspend fun getTrendingMovies(timeWindow: String): DomainResult<MovieResult> = movieRemoteDataSource.getTrendingMovies(timeWindow).mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    suspend fun getLatestMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getLatestMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    suspend fun getTopRatedMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getTopRatedMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    suspend fun getUpcomingMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getUpcomingMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    suspend fun getNowPlayingMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getNowPlayingMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

}