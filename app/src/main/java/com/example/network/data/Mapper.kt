package com.example.network.data

import com.example.network.domain.Product

object Mapper {

    fun ProductDto.mapToProduct(): Product {
        return Product(
            title = title,
            description = description
        )
    }
}