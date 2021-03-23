package com.example.todaymovie.data.repository

import com.example.todaymovie.data.Result
import com.example.todaymovie.domain.model.DomainResult


fun <I, O> Result<I>.mapTo(map: (I) -> O): DomainResult<O> {
    return if (this.status == Result.Status.LOADING) {
        DomainResult.loading(null)
    } else if (this.status == Result.Status.ERROR || this.data == null) {
        DomainResult.error(
                message = this.message.orEmpty(),
                errorCode = this.errorCode,
                error = null
        )
    } else {
        DomainResult.success(map(this.data))
    }
}
