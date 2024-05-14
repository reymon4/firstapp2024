package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.Character
import retrofit2.Response
import retrofit2.http.GET

interface UsersEndpoint {
    @GET("characters")
    //Encapsulamos el "Response" de la petición HTTP
    fun getAllUsers(): Response<List<Character>>
}