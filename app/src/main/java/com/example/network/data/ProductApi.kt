package com.example.network.data

import com.example.network.data.dto.AuthRequestDto
import com.example.network.data.dto.ProductDto
import com.example.network.data.dto.ProductsDto
import com.example.network.data.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {

    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): ProductDto

    @GET("auth/products/{id}")
    @Headers("Content-Type: application/json")
    suspend fun getAuthProduct(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    ): ProductDto

    @POST("auth/login")
    suspend fun auth(@Body authRequest: AuthRequestDto): UserDto

    @GET("products/search")
    suspend fun getProductsByName(@Query("q") name: String): ProductsDto

    //TODO пример с Response
}