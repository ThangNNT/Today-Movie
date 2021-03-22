package com.example.todaymovie.data

import com.example.todaymovie.data.remote.response.ErrorResponse

data class Result<out T>(val status: Status, val data: T?, val message: String?,val error:ErrorResponse?=null,val errorCode:Int? = null) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            return Result(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null, errorCode:Int?=null, error: ErrorResponse?=null): Result<T> {
            return Result(Status.ERROR, data, message,error=error,errorCode = errorCode)
        }

        fun <T> loading(data: T? = null): Result<T> {
            return Result(Status.LOADING, data, null)
        }

    }

}