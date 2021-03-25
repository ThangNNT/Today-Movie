package com.example.todaymovie.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TvHome
import com.example.todaymovie.domain.usecase.tv.GetHomeTVsUseCase
import com.example.todaymovie.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvViewModel @Inject constructor(private val getHomeTVsUseCase: GetHomeTVsUseCase): BaseViewModel() {

    private val _tvHome = MutableLiveData<DomainResult<TvHome>>()
    val tvHome: LiveData<DomainResult<TvHome>> = _tvHome

    init {
        getTvHome()
    }

    fun getTvHome(){
        _tvHome.value = DomainResult.loading(null)
        viewModelScope.launch {
            _tvHome.postValue(
                    getHomeTVsUseCase.execute(this, Unit)
            )
        }
    }
}