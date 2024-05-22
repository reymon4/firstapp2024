package com.reymon.myFirstApp.data.network.repository

import com.reymon.myFirstApp.data.local.repository.NewsInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBase {

    const val NEWS_API_KEY = "jex62NUy7LAP2O78cmtMCxzI2Fhq28RAjgIWp7fC"

    //Patrón de diseño BUILDER
    fun returnBaseRetrofitDB(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun returnBaseRetrofitNews(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thenewsapi.com/v1/news/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClient())
            .build()
    }
    private fun apiClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(NewsInterceptor(NEWS_API_KEY))
        .build()


}