package com.example.network.data

import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductDto
}