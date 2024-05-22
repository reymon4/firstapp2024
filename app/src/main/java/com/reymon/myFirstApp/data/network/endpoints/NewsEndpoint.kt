package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.allNews.AllNews
import com.reymon.myFirstApp.data.network.entities.topNews.NewsApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEndpoint {

    //@GET("top")
    //en esta sección van los headers
   /* suspend fun getAllTopNews(
        @Query("api_key")apiKey: String,
        @Query("locale")locale: String,
        @Query("limit")limit: Int
    )*/
    @GET("top")
    suspend fun getAllTopNews(): Response<NewsApi>
    @GET("all")
    suspend fun getAllNews(): Response<AllNews>
}
