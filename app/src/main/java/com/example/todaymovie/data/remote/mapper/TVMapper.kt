package com.example.todaymovie.data.remote.mapper

import com.example.todaymovie.data.remote.response.MovieResponse
import com.example.todaymovie.data.remote.response.RemoteMovie
import com.example.todaymovie.data.remote.response.RemoteTV
import com.example.todaymovie.data.remote.response.TvResponse
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.model.TV
import com.example.todaymovie.domain.model.TvResult
import javax.inject.Inject

class TVMapper @Inject constructor() {

    fun mapRemoteTVResponseToDomain(input: TvResponse): TvResult {
        return TvResult(
            page = input.page,
            results = mapRemoteTVListToDomain(input = input.results),
            totalResults = input.total_results,
            totalPages = input.total_pages
        )
    }

    fun mapRemoteTVListToDomain(input: List<RemoteTV>?): List<TV>?{
        return input?.map {
            mapRemoteMovieToDomain(it)
        }
    }

    fun mapRemoteMovieToDomain(input: RemoteTV?): TV {
        return TV(
            posterPath = input?.poster_path,
            overview = input?.overview,
            firstAirDate = input?.first_air_date,
            genreIds = input?.genre_ids,
            id = input?.id,
            originalName = input?.original_name,
            originCountry = input?.origin_country,
            originalLanguage = input?.original_language,
            name = input?.name,
            backdropPath = input?.backdrop_path,
            popularity = input?.popularity,
            voteCount = input?.vote_count,
            video = input?.video,
            voteAverage = input?.vote_average
        )
    }
}