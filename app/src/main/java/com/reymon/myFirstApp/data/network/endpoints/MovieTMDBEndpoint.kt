package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.tmdb.Movie
import com.reymon.myFirstApp.data.network.entities.topNews.NewsApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface MovieTMDBEndpoint {

    @GET("top_rated")

    suspend fun getAllTop(): Response<Movie>
}