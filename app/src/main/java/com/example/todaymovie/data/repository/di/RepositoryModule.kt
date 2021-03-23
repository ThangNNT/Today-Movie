package com.example.todaymovie.data.repository.di

import com.example.todaymovie.data.remote.datasource.MovieRemoteDataSource
import com.example.todaymovie.data.remote.mapper.MovieMapper
import com.example.todaymovie.data.repository.MovieRepositoryImpl
import com.example.todaymovie.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieRemoteDataSource: MovieRemoteDataSource, movieMapper: MovieMapper): MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieMapper)
    }
}