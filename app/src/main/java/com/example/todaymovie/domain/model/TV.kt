package com.example.todaymovie.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class TvResult(
        val page: Int?,
        val results: List<TV>?,
        val totalResults: Int?,
        val totalPages: Int?
)

@Parcelize
data class TV(
        val posterPath: String?,
        val overview: String?,
        val firstAirDate: String?,
        val genreIds: List<Int>?,
        val id: String?,
        val originalName: String?,
        val originCountry: List<String>?,
        val originalLanguage: String?,
        val name: String?,
        val backdropPath: String?,
        val popularity: Float?,
        val voteCount: Int?,
        val video: Boolean?,
        val voteAverage: Float?
): Parcelable