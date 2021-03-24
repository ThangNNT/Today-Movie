package com.example.todaymovie.data.remote.mapper

import com.example.todaymovie.data.remote.response.MovieResponse
import com.example.todaymovie.data.remote.response.RemoteMovie
import com.example.todaymovie.domain.model.Movie
import com.example.todaymovie.domain.model.MovieResult
import javax.inject.Inject

class MovieMapper @Inject constructor() {

    fun mapRemoteMovieResponseToDomain(input: MovieResponse): MovieResult {
        return MovieResult(
            page = input.page,
            results = mapRemoteMovieListToDomain(input = input.results),
            totalResults = input.total_results,
            totalPages = input.total_pages
        )
    }

    fun mapRemoteMovieListToDomain(input: List<RemoteMovie>?): List<Movie>?{
        return input?.map {
            mapRemoteMovieToDomain(it)
        }
    }

    fun mapRemoteMovieToDomain(input: RemoteMovie?): Movie {
        return Movie(
            posterPath = input?.poster_path,
            adult = input?.adult,
            overview = input?.overview,
            releaseDate = input?.release_date,
            genreIds = input?.genre_ids,
            id = input?.id,
            originalTitle = input?.original_title,
            originalLanguage = input?.original_language,
            title = input?.title,
            backdropPath = input?.backdrop_path,
            popularity = input?.popularity,
            voteCount = input?.vote_count,
            video = input?.video,
            voteAverage = input?.vote_average
        )
    }
}