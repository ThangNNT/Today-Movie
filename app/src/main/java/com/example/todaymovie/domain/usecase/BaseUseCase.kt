package com.example.todaymovie.domain.usecase

import kotlinx.coroutines.CoroutineScope

abstract class BaseUseCase<O,P>(){
    abstract suspend fun execute(scope: CoroutineScope, params: P): O
}