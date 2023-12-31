package com.example.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        Log.d("NetworkInterceptor", response.toString())
        return response
    }
}