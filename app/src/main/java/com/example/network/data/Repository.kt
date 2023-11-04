package com.example.network.data

import com.example.network.data.Mapper.mapToAuthRequestDto
import com.example.network.data.Mapper.mapToProduct
import com.example.network.data.Mapper.mapToUser
import com.example.network.domain.AuthRequest
import com.example.network.domain.Product
import com.example.network.domain.User

class Repository(private val productApi: ProductApi) {

    suspend fun getProduct(id: Int): Product {
        return productApi.getProduct(id).mapToProduct()
    }

    suspend fun auth(authRequest: AuthRequest): User {
        return productApi.auth(authRequest.mapToAuthRequestDto()).mapToUser()
    }
}