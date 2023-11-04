package com.example.network

import com.example.network.data.ProductApi
import com.example.network.data.Repository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Di {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val productApi = retrofit.create(ProductApi::class.java)
    private val repository = Repository(productApi)
    private val viewModel = MainScreenViewModel(repository)

    fun inject(activity: MainActivity) {
        activity.viewModel = viewModel
    }
}