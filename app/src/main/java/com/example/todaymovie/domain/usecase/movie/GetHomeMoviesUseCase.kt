package com.example.todaymovie.domain.usecase.movie

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.domain.model.MovieHome
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async


class GetHomeMoviesUseCase constructor(
        private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
        private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
        private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
        private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
        private val getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase
): BaseUseCase<DomainResult<MovieHome>, Unit>() {

    override suspend fun execute(scope: CoroutineScope, params: Unit): DomainResult<MovieHome>{
        val popularDeferred = scope.async {
            getPopularMoviesUseCase.execute(scope, Unit)
        }
        val topRatedDeferred = scope.async {
            getTopRatedMoviesUseCase.execute(scope, Unit)
        }
        val trendingDeferred = scope.async {
            getTrendingMoviesUseCase.execute(scope, Unit)
        }
        val upcomingDeferred = scope.async {
            getUpcomingMoviesUseCase.execute(scope, Unit)
        }
        val nowPlayingDeferred = scope.async {
            getNowPlayingMoviesUseCase.execute(scope, Unit)
        }
        val popularResult = popularDeferred.await()
        val topRatedResult = topRatedDeferred.await()
        val trendingResult = trendingDeferred.await()
        val upcomingResult = upcomingDeferred.await()
        val nowPlayingResult = nowPlayingDeferred.await()

        val movieHome = MovieHome(nowPlayingMovies = nowPlayingResult.data?.results,
                popularMovies = popularResult.data?.results,
                topRateMovies = topRatedResult.data?.results ,
                trendingMovies = trendingResult.data?.results,
                upcomingMovies = upcomingResult.data?.results)
        return if(movieHome.popularMovies==null && movieHome.topRateMovies==null
                && movieHome.trendingMovies ==null && movieHome.upcomingMovies==null && movieHome.nowPlayingMovies==null){
            DomainResult.error(message = "some api went wrong")
        }
        else DomainResult.success(movieHome)
    }


}