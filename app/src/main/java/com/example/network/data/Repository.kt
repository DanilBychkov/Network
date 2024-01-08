package com.example.network.data

import com.example.network.data.Mapper.mapToAuthRequestDto
import com.example.network.data.Mapper.mapToProduct
import com.example.network.data.Mapper.mapToProducts
import com.example.network.data.Mapper.mapToUser
import com.example.network.domain.AuthRequest
import com.example.network.domain.Product
import com.example.network.domain.Products
import com.example.network.domain.User

class Repository(private val productApi: ProductApi) {

    suspend fun getProduct(id: Int): Product {
        return productApi.getProduct(id).mapToProduct()
    }

    suspend fun getAuthProduct(id: Int, user: User): Product {
        return productApi.getAuthProduct("user.token", id).mapToProduct()
    }

    suspend fun auth(authRequest: AuthRequest): User {
        val user = productApi.auth(authRequest.mapToAuthRequestDto())
        user.onFailure {
            val t = 1
        }.onSuccess {
            val v = 2
        }
        return user.getOrNull()?.mapToUser()!!
    }

    suspend fun getProductsByName(name: String): Products {
        return productApi.getProductsByName(name).mapToProducts()
    }
}