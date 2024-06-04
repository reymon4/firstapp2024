package com.reymon.myFirstApp.data.network.repository

import com.reymon.myFirstApp.data.local.repository.NewsInterceptor
import com.reymon.myFirstApp.data.local.repository.TMDBInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBase {

    const val NEWS_API_KEY = "jex62NUy7LAP2O78cmtMCxzI2Fhq28RAjgIWp7fC"
    const val TMDB_API_KEY = "6bef7d35443483b3cccb355a0cc5cdd3"
    const val TMDB_AUTH_TOKEN =
        "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2YmVmN2QzNTQ0MzQ4M2IzY2NjYjM1NWEwY2M1Y2RkMyIsInN1YiI6IjY2NWQ0NzllYzg4OGMwMjg5YWRkN2UwOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.2w-UurI303JGu35shU04Bpc4Ke8095mL-U2DVJjHgfE"

    //Patrón de diseño BUILDER
    fun returnBaseRetrofitDB(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dragonball-api.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//    fun returnBaseRetrofitNews(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://api.thenewsapi.com/v1/news/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(apiClient())
//            .build()
//    }

    fun returnBaseRetrofitTMDB(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClient())
            .build()
    }

    private fun apiClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(TMDBInterceptor(TMDB_AUTH_TOKEN))
        .build()


}