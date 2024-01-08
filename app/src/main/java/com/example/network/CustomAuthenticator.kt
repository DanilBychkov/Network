package com.example.network

import android.util.Log
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class CustomAuthenticator() : Authenticator {

    /**
     * Вызывается только при 401 коде ошибки
     */
    override fun authenticate(route: Route?, response: Response): Request? {
        Log.d("Authenticatior", response.message)
        return null
    }
}