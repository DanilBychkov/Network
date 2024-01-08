package com.example.network

import android.util.Log
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.connection.RealCall

class CustomCallFactory(private val client: OkHttpClient) : Call.Factory {
    override fun newCall(request: Request): Call {
        Log.d("CustomCallFactory", "Request: $request")
        val call = RealCall(client, request, false)
        Log.d("CustomCallFactory", "Request: $call")
        return call
    }
}