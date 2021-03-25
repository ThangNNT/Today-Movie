package com.example.todaymovie.data.repository

import com.example.todaymovie.data.Result
import com.example.todaymovie.data.remote.datasource.TVRemoteDataSource
import com.example.todaymovie.data.remote.mapper.TVMapper
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TV
import com.example.todaymovie.domain.model.TvResult
import com.example.todaymovie.domain.repository.TVRepository
import javax.inject.Inject

class TVRepositoryImpl @Inject constructor(private val dataSource: TVRemoteDataSource, private val mapper: TVMapper): TVRepository {
    override suspend fun getPopularTVs(): DomainResult<TvResult> {
        return dataSource.getPopularTVs().mapTo {
            mapper.mapRemoteTVResponseToDomain(it)
        }
    }

    override suspend fun getTopRatedTVs(): DomainResult<TvResult> {
        return dataSource.getTopRatedTVs().mapTo {
            mapper.mapRemoteTVResponseToDomain(it)
        }
    }

    override suspend fun getOnTheAirTVs(): DomainResult<TvResult> {
        return dataSource.getOnTheAirTVs().mapTo {
            mapper.mapRemoteTVResponseToDomain(it)
        }
    }

    override suspend fun getAiringToday(): DomainResult<TvResult> {
        return dataSource.getAiringToday().mapTo {
            mapper.mapRemoteTVResponseToDomain(it)
        }
    }

    override suspend fun getTrending(): DomainResult<TvResult> {
        return dataSource.getTrending(TRENDING_DAY).mapTo {
            mapper.mapRemoteTVResponseToDomain(it)
        }
    }

    companion object {
        private const val TRENDING_DAY = "day"
        private const val TRENDING_WEEK ="week"
    }
}