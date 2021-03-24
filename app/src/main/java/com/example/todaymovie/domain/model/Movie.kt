package com.example.todaymovie.domain.model

data class MovieResult(
    val page: Int?,
    val results: List<Movie>?,
    val totalResults: Int?,
    val totalPages: Int?
)

data class Movie(
    val posterPath: String?,
    val adult: Boolean?,
    val overview: String?,
    val releaseDate: String?,
    val genreIds: List<Int>?,
    val id: String?,
    val originalTitle: String?,
    val originalLanguage: String?,
    val title: String?,
    val backdropPath: String?,
    val popularity: Float?,
    val voteCount: Int?,
    val video: Boolean?,
    val voteAverage: Float?
)