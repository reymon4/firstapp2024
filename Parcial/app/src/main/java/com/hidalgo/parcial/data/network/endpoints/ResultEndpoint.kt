package com.hidalgo.parcial.data.network.endpoints

import com.hidalgo.parcial.data.network.entities.Message
import retrofit2.Response
import retrofit2.http.GET

interface ResultEndpoint {

    /*LA BARRA PORQUE NO HAY "ENDPOINT"*/
    @GET("./")
    suspend fun getAllMessages(): Response<Message>
}