package com.reymon.myFirstApp.data.network.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBase {
    //Patrón de diseño BUILDER
    fun returnBaseRetrofitDB(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun returnBaseRetrofitNews(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.thenewsapi.com/v1/news/headlines HTTP/1.1")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}