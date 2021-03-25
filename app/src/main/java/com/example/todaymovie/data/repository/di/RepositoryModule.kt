package com.example.todaymovie.data.repository.di

import com.example.todaymovie.data.remote.datasource.MovieRemoteDataSource
import com.example.todaymovie.data.remote.datasource.TVRemoteDataSource
import com.example.todaymovie.data.remote.mapper.MovieMapper
import com.example.todaymovie.data.remote.mapper.TVMapper
import com.example.todaymovie.data.repository.MovieRepositoryImpl
import com.example.todaymovie.data.repository.TVRepositoryImpl
import com.example.todaymovie.domain.repository.MovieRepository
import com.example.todaymovie.domain.repository.TVRepository
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

    @Singleton
    @Provides
    fun provideTvRepository(tvRemoteDataSource: TVRemoteDataSource, tvMapper: TVMapper): TVRepository{
        return TVRepositoryImpl(tvRemoteDataSource, tvMapper)
    }
}