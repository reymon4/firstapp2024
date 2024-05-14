package com.reymon.myFirstApp.data.network.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBase {
    //Patrón de diseño BUILDER
    fun returnBaseRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(" https://www.dragonball-api.com/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Siempre debemos usar etiquetas para los métodos HTTP que vamos a usar

}