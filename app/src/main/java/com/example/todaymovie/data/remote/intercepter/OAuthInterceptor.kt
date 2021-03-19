package com.example.todaymovie.data.remote.intercepter

import com.example.todaymovie.BuildConfig
import okhttp3.Interceptor

class OAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val requestOrigin = chain.request()
        val originHttp = requestOrigin.url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .build()

        val request = requestOrigin.newBuilder()
            .url(originHttp)
            .build()
//        request = request.newBuilder().header("Authorization", "Bearer ${AppPreferences.getUserAccessToken()}").build()
        return chain.proceed(request)
    }
}