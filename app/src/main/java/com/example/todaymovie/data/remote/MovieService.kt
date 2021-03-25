package com.example.todaymovie.data.remote

import com.example.todaymovie.data.remote.response.MovieResponse
import com.example.todaymovie.data.remote.response.TvResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(): Response<MovieResponse>

    @GET("3/trending/movie/{timeWindow}")
    suspend fun getTrendingMovies(@Path("timeWindow") timeWindow: String): Response<MovieResponse>

    @GET("3/movie/latest")
    suspend fun getLatestMovies(): Response<MovieResponse>

    @GET("3/movie/top_rated")
    suspend fun getTopRatedMovies(): Response<MovieResponse>

    @GET("3/movie/upcoming")
    suspend fun getUpcomingMovies(): Response<MovieResponse>

    @GET("3/movie/now_playing")
    suspend fun getNowPlayingMovies(): Response<MovieResponse>

    @GET("3/tv/popular")
    suspend fun getPopularTVs(): Response<TvResponse>

    @GET("3/tv/top_rated")
    suspend fun getTopRatedTVs(): Response<TvResponse>

    @GET("3/tv/on_the_air")
    suspend fun getOnTheAirTVs(): Response<TvResponse>

    @GET("3/tv/airing_today")
    suspend fun getAiringToday(): Response<TvResponse>

    @GET("3/trending/tv/{time_window}")
    suspend fun getTrending(@Path("time_window") windowTime: String): Response<TvResponse>

}