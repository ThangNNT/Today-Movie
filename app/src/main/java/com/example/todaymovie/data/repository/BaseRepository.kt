package com.example.todaymovie.data.repository

import com.example.todaymovie.data.Result

open class BaseRepository {

    protected fun <I,O> Result<I>.mapTo(map:(I)->O): Result<O>{
        return if(this.status==Result.Status.LOADING){
            Result.loading(null)
        } else if(this.status == Result.Status.ERROR || this.data==null){
            Result.error(
                message = this.message.orEmpty(),
                errorCode = this.errorCode,
                error = null
            )
        } else {
            Result.success(map(this.data))
        }
    }
}