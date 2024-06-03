package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.tmdb.Movie
import com.reymon.myFirstApp.data.network.entities.topNews.NewsApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieTMDBEndpoint {

    @GET("top_rated")

    suspend fun getAllTop(@Header("Authorization") apiKey:String="Bearer 6bef7d35443483b3cccb355a0cc5cdd3",@Header("Accept") accept: String = "application/json"): Response<Movie>
}