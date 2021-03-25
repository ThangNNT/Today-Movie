package com.example.todaymovie.domain.repository

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TvResult

interface TVRepository {
    suspend fun getPopularTVs(): DomainResult<TvResult>

    suspend fun getTopRatedTVs(): DomainResult<TvResult>

    suspend fun getOnTheAirTVs(): DomainResult<TvResult>

    suspend fun getAiringToday(): DomainResult<TvResult>

    suspend fun getTrending(): DomainResult<TvResult>
}