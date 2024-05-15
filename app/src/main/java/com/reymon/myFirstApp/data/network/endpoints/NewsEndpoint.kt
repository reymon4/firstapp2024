package com.reymon.myFirstApp.data.network.endpoints

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEndpoint {

    @GET("top")
    //en esta sección van los headers
    suspend fun getAllTopNews(
        @Query("api_key")apiKey: String,
        @Query("locale")locale: String,
        @Query("limit")limit: Int
    )
}