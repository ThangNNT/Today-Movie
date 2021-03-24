package com.example.todaymovie.di

import com.example.todaymovie.domain.repository.MovieRepository
import com.example.todaymovie.domain.usecase.movie.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideGetLatestMoviesUseCase(movieRepository: MovieRepository): GetLatestMoviesUseCase{
        return GetLatestMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetNowPlayingMoviesUseCase(movieRepository: MovieRepository): GetNowPlayingMoviesUseCase{
        return GetNowPlayingMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetPopularMoviesUseCase(movieRepository: MovieRepository): GetPopularMoviesUseCase{
        return GetPopularMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetTopRatedMoviesUseCase(movieRepository: MovieRepository): GetTopRatedMoviesUseCase{
        return GetTopRatedMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetTrendingMoviesUseCase(movieRepository: MovieRepository): GetTrendingMoviesUseCase{
        return GetTrendingMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetUpcomingMoviesUseCase(movieRepository: MovieRepository): GetUpcomingMoviesUseCase{
        return GetUpcomingMoviesUseCase(movieRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetMovieHomeUseCase(getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
                                   getPopularMoviesUseCase: GetPopularMoviesUseCase,
                                   getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
                                   getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
                                   getUpcomingMoviesUseCase: GetUpcomingMoviesUseCase): GetHomeMoviesUseCase{
        return GetHomeMoviesUseCase(getNowPlayingMoviesUseCase, getPopularMoviesUseCase, getTopRatedMoviesUseCase, getTrendingMoviesUseCase, getUpcomingMoviesUseCase)
    }
}