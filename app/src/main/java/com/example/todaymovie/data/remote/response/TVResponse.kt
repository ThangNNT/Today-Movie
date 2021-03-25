package com.example.todaymovie.data.remote.response

data class TvResponse(
    val page: Int?,
    val results: List<RemoteTV>?,
    val total_results: Int?,
    val total_pages: Int?
)

data class RemoteTV(
    val poster_path: String?,
    val overview: String?,
    val first_air_date: String?,
    val genre_ids: List<Int>?,
    val id: String?,
    val original_name: String?,
    val origin_country: List<String>?,
    val original_language: String?,
    val name: String?,
    val backdrop_path: String?,
    val popularity: Float?,
    val vote_count: Int?,
    val video: Boolean?,
    val vote_average: Float?
)