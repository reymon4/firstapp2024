package com.reymon.myFirstApp.logic.usercases

import android.util.Log
import com.reymon.myFirstApp.data.network.endpoints.CharactersEndpoint
import com.reymon.myFirstApp.data.network.repository.RetrofitBase

class GetAllCharactersUserCase {

    suspend operator fun invoke(){
        val call = RetrofitBase.returnBaseRetrofitDB()
        //Creo el servicio con el respectivo endpoint
        val service =call.create(CharactersEndpoint::class.java)
        val response = service.getAllUsers()
        if(response.isSuccessful){
            Log.d("Get all Characteres", response.body().toString())
        }else {
            Log.d("Get all Characteres", "Cannot connect to API")
        }
    }
}