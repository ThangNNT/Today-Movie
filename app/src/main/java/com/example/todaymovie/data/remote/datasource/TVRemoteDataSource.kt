package com.example.todaymovie.data.remote.datasource

import com.example.todaymovie.data.Result
import com.example.todaymovie.data.remote.MovieService
import com.example.todaymovie.data.remote.response.TvResponse
import javax.inject.Inject

interface TVRemoteDataSource {

    suspend fun getPopularTVs(): Result<TvResponse>

    suspend fun getTopRatedTVs(): Result<TvResponse>

    suspend fun getOnTheAirTVs(): Result<TvResponse>

    suspend fun getAiringToday(): Result<TvResponse>

    suspend fun getTrending(windowTime: String): Result<TvResponse>

}

class TVRemoteDataSourceImpl @Inject constructor(private val service: MovieService): TVRemoteDataSource{
    override suspend fun getPopularTVs(): Result<TvResponse> = getResult {
        service.getPopularTVs()
    }

    override suspend fun getTopRatedTVs(): Result<TvResponse> = getResult {
        service.getTopRatedTVs()
    }

    override suspend fun getOnTheAirTVs(): Result<TvResponse> = getResult {
        service.getOnTheAirTVs()
    }

    override suspend fun getAiringToday(): Result<TvResponse> = getResult {
        service.getAiringToday()
    }

    override suspend fun getTrending(windowTime: String): Result<TvResponse> = getResult {
        service.getTrending(windowTime)
    }

}