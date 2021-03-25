package com.example.todaymovie.domain.model


data class TvHome(
        val onTheAirTv: List<TV>?,
        val popularTv: List<TV>?,
        val topRateTv: List<TV>?,
        val trendingTv: List<TV>?,
        val airingTodayTv: List<TV>?
)