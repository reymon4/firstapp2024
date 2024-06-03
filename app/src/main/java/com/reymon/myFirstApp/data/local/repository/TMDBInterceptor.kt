package com.reymon.myFirstApp.data.local.repository

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class TMDBInterceptor (private val apiKey: String) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val newUrl = chain.request()
            .url.newBuilder()
            .addQueryParameter("api_token", apiKey)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        Log.d("TAG", newRequest.url.toString())
        return chain.proceed(newRequest)
    }
}