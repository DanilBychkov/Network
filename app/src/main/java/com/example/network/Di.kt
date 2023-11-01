package com.example.network

import com.example.network.data.ProductApi
import com.example.network.data.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Di {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val productApi = retrofit.create(ProductApi::class.java)
    private val repository = Repository(productApi)

    fun provideMainScreenViewModel(): MainScreenViewModel {
        return MainScreenViewModel(repository)
    }
}