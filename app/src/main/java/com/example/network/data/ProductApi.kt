package com.example.network.data

import com.example.network.data.dto.AuthRequestDto
import com.example.network.data.dto.ProductDto
import com.example.network.data.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductApi {

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductDto

    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequestDto): UserDto
}