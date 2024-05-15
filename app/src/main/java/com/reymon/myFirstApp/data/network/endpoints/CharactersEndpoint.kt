package com.reymon.myFirstApp.data.network.endpoints

import com.reymon.myFirstApp.data.network.entities.Character
import retrofit2.Response
import retrofit2.http.GET

interface CharactersEndpoint {
    //Siempre debemos usar etiquetas para los métodos HTTP que vamos a usar

    @GET("characters")
    //Encapsulamos el "Response" de la petición HTTP
    //Digitamos "suspend", porque ejecutaremos dentro de una corrutina
    //OJO CUANDO SE RECIBA UNA LISTA[] O NO EN LA PETICIÓN
    //EN ESTE CASO NO SE RECIBE UNA LISTA DE JSONS. o SEA, [{} Y AQUI LOS OBJETOS]
    //Por eso, no pongo una lista, porque en este endpoint no tengo una lista
    suspend fun getAllUsers(): Response<Character>
}