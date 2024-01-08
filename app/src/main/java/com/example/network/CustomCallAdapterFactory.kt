package com.example.network

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class CustomCallAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (getRawType(returnType) != Call::class.java || returnType !is ParameterizedType) return null

        val resultType = getParameterUpperBound(0, returnType)
        return CustomCallAdapter<Any>(resultType)
    }
}


class CustomCallAdapter<T : Any>(private val type: Type) : CallAdapter<T, StateFlow<T?>> {

    override fun responseType(): Type {
        return type
    }

    override fun adapt(call: Call<T>): StateFlow<T?> {
        val state = MutableStateFlow<T?>(null)

        val callBack = object : Callback<T> {

            override fun onResponse(call: Call<T>, response: Response<T>) {
                state.value = response.body()
            }

            override fun onFailure(call: Call<T>, t: Throwable) {

            }

        }

        call.enqueue(callBack)

        return state.asStateFlow()
    }

}
