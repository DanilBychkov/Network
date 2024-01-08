package com.example.network

import android.util.Log
import com.example.network.data.ProductApi
import com.example.network.data.Repository
import com.example.network.javadynamicproxy.AppClickLogger
import com.example.network.javadynamicproxy.ClickTracker
import com.example.network.javadynamicproxy.LoggerProxy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class Di {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .authenticator(CustomAuthenticator())
        .addInterceptor(interceptor)
        .callTimeout(0, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .addNetworkInterceptor(NetworkInterceptor())
        .build()

    private val callFactory = CustomCallFactory(client)

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .client(client)
        .callFactory(callFactory)
        .addConverterFactory(CustomConverterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .validateEagerly(false) // Если установить в true, то из-за неизвестной аннотации приложение упадет
        .build()


    private val productApi = retrofit.create(ProductApi::class.java)
    private val repository = Repository(productApi)
    private val viewModel = MainScreenViewModel(repository)

    private val clickTracker = object : ClickTracker {
        override fun trackClick(place: String) {
            Log.d("Track", place)
        }

    }

    private val loggerProxy = LoggerProxy.Builder().clickTracker(clickTracker).build()
    private val logger = loggerProxy.create(AppClickLogger::class.java)

    fun inject(activity: MainActivity) {
        activity.viewModel = viewModel
        logger.click("Activity")
    }
}