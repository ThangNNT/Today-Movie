package com.example.todaymovie.domain.model

data class DomainResult<out T>(val status: Status, val data: T?, val message: String?, val error:ErrorResult?=null, val errorCode:Int? = null) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): DomainResult<T> {
            return DomainResult(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null, errorCode:Int?=null, error: ErrorResult?=null): DomainResult<T> {
            return DomainResult(Status.ERROR, data, message,error=error,errorCode = errorCode)
        }

        fun <T> loading(data: T? = null): DomainResult<T> {
            return DomainResult(Status.LOADING, data, null)
        }

    }

}