package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.tmdb.Movie
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.TopRated
import retrofit2.Response
import retrofit2.http.GET

interface TopRatedEndpoint {

    @GET("top_rated")

    suspend fun getAllTop(): Response<TopRated>
}