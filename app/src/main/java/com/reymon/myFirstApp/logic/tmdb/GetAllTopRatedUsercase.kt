package com.reymon.myFirstApp.logic.tmdb

import android.util.Log
import com.reymon.myFirstApp.data.network.endpoints.CharactersEndpoint
import com.reymon.myFirstApp.data.network.endpoints.MovieTMDBEndpoint
import com.reymon.myFirstApp.data.network.repository.RetrofitBase

class GetAllTopRatedUsercase {
    suspend operator fun invoke(){
        val call = RetrofitBase.returnBaseRetrofitTMDB()
        //Creo el servicio con el respectivo endpoint
        val service =call.create(MovieTMDBEndpoint::class.java)
        val response = service.getAllTop()
        if(response.isSuccessful){
            Log.d("Get all Top", response.body().toString())
        }else {
            Log.d("Get all Top", "Cannot connect to API")
        }
    }
}
