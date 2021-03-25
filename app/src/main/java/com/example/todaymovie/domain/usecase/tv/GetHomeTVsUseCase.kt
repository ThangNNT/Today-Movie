package com.example.todaymovie.domain.usecase.tv

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TvHome
import com.example.todaymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.internal.wait

class GetHomeTVsUseCase(private val getAiringTodayTVsUseCase: GetAiringTodayTVsUseCase,
                        private val getOnTheAirTVsUseCase: GetOnTheAirTVsUseCase,
                        private val getPopularTVsUseCase: GetPopularTVsUseCase,
                        private val getTopRatedTVsUseCase: GetTopRatedTVsUseCase,
                        private val getTrendingTVsUseCase: GetTrendingTVsUseCase) : BaseUseCase<DomainResult<TvHome>, Unit>() {
    override suspend fun execute(scope: CoroutineScope, params: Unit): DomainResult<TvHome> {
        val airingTodayDeferred = scope.async(Dispatchers.IO){
            getAiringTodayTVsUseCase.execute(scope, Unit)
        }
        val onTheAirDeferred = scope.async(Dispatchers.IO){
            getOnTheAirTVsUseCase.execute(scope, Unit)
        }
        val popularDeferred = scope.async(Dispatchers.IO){
            getPopularTVsUseCase.execute(scope, Unit)
        }
        val topRatedDeferred = scope.async(Dispatchers.IO){
            getTopRatedTVsUseCase.execute(scope, Unit)
        }
        val trendingDeferred = scope.async(Dispatchers.IO){
            getTrendingTVsUseCase.execute(scope, Unit)
        }

        val airingTodayResult = airingTodayDeferred.await()
        val onTheAirResult = onTheAirDeferred.await()
        val popularResult = popularDeferred.await()
        val topRatedResult = topRatedDeferred.await()
        val trendingResult = trendingDeferred.await()

        val tvHome = TvHome(
                onTheAirTv = onTheAirResult.data?.results,
                airingTodayTv = airingTodayResult.data?.results,
                popularTv = popularResult.data?.results,
                topRateTv = topRatedResult.data?.results,
                trendingTv = trendingResult.data?.results
        )
        if(tvHome.onTheAirTv == null && tvHome.airingTodayTv == null && tvHome.popularTv == null
                && tvHome.topRateTv == null && tvHome.trendingTv == null){
            return DomainResult.error("some api went wrong")
        }
        else {
            return DomainResult.success(tvHome)
        }
    }
}