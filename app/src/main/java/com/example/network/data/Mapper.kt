package com.example.network.data

import com.example.network.data.dto.AuthRequestDto
import com.example.network.data.dto.ProductDto
import com.example.network.data.dto.ProductsDto
import com.example.network.data.dto.UserDto
import com.example.network.domain.AuthRequest
import com.example.network.domain.Product
import com.example.network.domain.Products
import com.example.network.domain.User

object Mapper {

    fun ProductDto.mapToProduct(): Product {
        return Product(
            title = title,
            description = description
        )
    }

    fun UserDto.mapToUser(): User {
        return User(
            id = id,
            firstName = firstName,
            lastName = lastName,
            token = token
        )
    }

    fun AuthRequest.mapToAuthRequestDto(): AuthRequestDto {
        return AuthRequestDto(
            username = username,
            password = password
        )
    }

    fun ProductsDto.mapToProducts(): Products {
        return Products(
            products = products.map { it.mapToProduct() }
        )
    }
}