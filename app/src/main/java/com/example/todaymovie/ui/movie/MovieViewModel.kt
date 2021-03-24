package com.example.todaymovie.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.MovieHome
import com.example.todaymovie.domain.model.MovieResult
import com.example.todaymovie.domain.usecase.movie.GetHomeMoviesUseCase
import com.example.todaymovie.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val getHomeMoviesUseCase: GetHomeMoviesUseCase): BaseViewModel() {

    private val _movieHome = MutableLiveData<DomainResult<MovieHome>>()
    val movieHome: LiveData<DomainResult<MovieHome>> = _movieHome

    init {
        getHomeMovies()
    }
    private fun getHomeMovies(){
        _movieHome.value = DomainResult.loading(null)
        viewModelScope.launch {
            _movieHome.postValue(getHomeMoviesUseCase.execute(this, Unit))
        }
    }
}