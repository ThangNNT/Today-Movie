package com.example.todaymovie.data.repository

import com.example.todaymovie.data.remote.datasource.MovieRemoteDataSource
import com.example.todaymovie.data.remote.mapper.MovieMapper
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieRemoteDataSource: MovieRemoteDataSource, private val movieMapper: MovieMapper): MovieRepository {

    override suspend fun getPopularMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getPopularMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    override suspend fun getTrendingMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getTrendingMovies(TRENDING_DAY).mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    override suspend fun getLatestMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getLatestMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    override suspend fun getTopRatedMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getTopRatedMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    override suspend fun getUpcomingMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getUpcomingMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    override suspend fun getNowPlayingMovies(): DomainResult<MovieResult> = movieRemoteDataSource.getNowPlayingMovies().mapTo {
        movieMapper.mapRemoteMovieResponseToDomain(it)
    }

    companion object {
        private const val TRENDING_DAY = "day"
        private const val TRENDING_WEEK ="week"
    }

}