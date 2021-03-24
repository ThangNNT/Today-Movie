package com.example.todaymovie.data.remote.response

data class MovieResponse(
    val page: Int?,
    val results: List<RemoteMovie>?,
    val total_results: Int?,
    val total_pages: Int?
)

data class RemoteMovie(
    val poster_path: String?,
    val adult: Boolean?,
    val overview: String?,
    val release_date: String?,
    val genre_ids: List<Int>?,
    val id: String?,
    val original_title: String?,
    val original_language: String?,
    val title: String?,
    val backdrop_path: String?,
    val popularity: Float?,
    val vote_count: Int?,
    val video: Boolean?,
    val vote_average: Float?
)