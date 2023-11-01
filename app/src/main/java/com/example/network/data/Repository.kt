package com.example.network.data

import com.example.network.data.Mapper.mapToProduct
import com.example.network.domain.Product

class Repository(private val productApi: ProductApi) {

    suspend fun getProduct(id: Int): Product {
        return productApi.getProduct(id).mapToProduct()
    }
}