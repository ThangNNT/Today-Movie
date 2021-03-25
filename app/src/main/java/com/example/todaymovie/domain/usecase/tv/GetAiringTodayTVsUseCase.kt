package com.example.todaymovie.domain.usecase.tv

import com.example.todaymovie.domain.model.DomainResult
import com.example.todaymovie.domain.model.TvResult
import com.example.todaymovie.domain.repository.TVRepository
import com.example.todaymovie.domain.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope

class GetAiringTodayTVsUseCase(private val repository: TVRepository): BaseUseCase<DomainResult<TvResult>, Unit>() {
    override suspend fun execute(scope: CoroutineScope, params: Unit): DomainResult<TvResult> {
        return repository.getAiringToday()
    }
}