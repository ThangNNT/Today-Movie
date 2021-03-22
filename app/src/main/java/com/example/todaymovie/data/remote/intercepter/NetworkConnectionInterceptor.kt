package com.example.todaymovie.data.remote.intercepter

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import com.example.todaymovie.R
import com.example.todaymovie.app.App
import com.example.todaymovie.util.NoInternetException
import dagger.hilt.android.qualifiers.ApplicationContext
import es.dmoral.toasty.Toasty
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class NetworkConnectionInterceptor @Inject constructor(@ApplicationContext
    context: Context
): Interceptor {
    private val applicationContext = context.applicationContext
    private var toast: Toast? = null
    private val handler = Handler(Looper.getMainLooper())
    override fun intercept(chain: Interceptor.Chain): Response {

        if(!isInternetAvailable()) {
            val urlString  =  chain.request().url.toString()
            if(!urlString.contains("notifications/status")){
                showErrorToast()
            }
            throw NoInternetException("Make sure you have an active data connection")
        }

        return chain.proceed(chain.request())

    }

    private fun isInternetAvailable() : Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val actNw =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    @SuppressLint("ShowToast")
    private fun showErrorToast(){
        handler.post {
            val context = App.getInstance()
            if(toast==null) {
                toast = Toasty.warning(context, context.getString(R.string.no_internet_warning), Toast.LENGTH_LONG)
                toast?.setGravity(Gravity.CENTER, 0, 0)
            }
            toast?.show()
        }
    }
}