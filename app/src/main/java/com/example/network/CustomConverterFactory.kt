package com.example.network

import com.example.network.data.dto.ProductDto
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CustomConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? = if (type == ProductDto::class.java) {
        //ErrorCustomConverter()
        /**
         * Если указать тип возвращаемого значения отличный от type,
         * то приложение упадет с ClassCastException
         */
        CustomConverter()
    } else {
        null
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        return null
    }

    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        return null
    }
}

class ErrorCustomConverter : Converter<ResponseBody, String> {

    override fun convert(value: ResponseBody): String {
        return ""
    }
}

class CustomConverter : Converter<ResponseBody, ProductDto> {
    override fun convert(value: ResponseBody): ProductDto {
        /**
         * С помощью  метода .string() можно получить тело ответа
         */
        val response = value.string()
        return ProductDto(
            brand = "Brand",
            category = "Category",
            description = "CustomResponseDescription",
            discountPercentage = Double.NaN,
            id = 0,
            images = listOf(),
            price = 0,
            rating = Double.NaN,
            stock = 0,
            thumbnail = "",
            title = "CustomResponseTitle"
        )
    }

}