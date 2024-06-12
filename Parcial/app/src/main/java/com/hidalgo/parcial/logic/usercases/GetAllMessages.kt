package com.hidalgo.parcial.logic.usercases

import android.util.Log
import com.hidalgo.parcial.data.network.endpoints.ResultEndpoint
import com.hidalgo.parcial.data.network.entities.ResultMessage
import com.hidalgo.parcial.data.network.repository.RetrofitBase
import java.lang.Exception

class GetAllMessages {
    suspend operator fun invoke(): Result<List<ResultMessage>?> {
        var items = mutableListOf<ResultMessage>()
        var response = RetrofitBase.returnBaseRetrofitResult()
            .create(ResultEndpoint::class.java)
            .getAllMessages()
        Log.d("API", response.toString())

        return if (response.isSuccessful) {
            response.body()?.resultMessages?.forEach() {
                items.add(
                    it
                )
            }
            Log.d("API", "Se ha conectado con la API")
            //Log.d("API", items.toString())
            Result.success(items.toList())
        } else {
            Result.failure(Exception("Error al conectar con la API"))
        }
    }

}