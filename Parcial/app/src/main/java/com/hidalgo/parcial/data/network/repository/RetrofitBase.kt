package com.hidalgo.parcial.data.network.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBase {

    fun returnBaseRetrofitResult(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://2c5f17142d37474d9984c8e631502e0b.api.mockbin.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}