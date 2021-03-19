package com.example.todaymovie.data.remote

import com.example.todaymovie.data.remote.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("3/movie/popular")
    suspend fun getPopularMovie(): Response<MovieResponse>

}