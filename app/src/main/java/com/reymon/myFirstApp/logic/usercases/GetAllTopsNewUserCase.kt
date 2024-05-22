package com.reymon.myFirstApp.logic.usercases

import com.reymon.myFirstApp.data.network.endpoints.NewsEndpoint


import com.reymon.myFirstApp.data.network.repository.RetrofitBase
import com.reymon.myFirstApp.data.network.entities.topNews.Data
import java.lang.Exception

class GetAllTopsNewUserCase {

    suspend operator fun invoke(): Result<List<Data>?> {

        var response = RetrofitBase.returnBaseRetrofitNews()
            .create(NewsEndpoint::class.java)
            .getAllTopNews()

        return if (response.isSuccessful) {
            Result.success(response.body()?.data)
        } else {
            Result.failure(Exception("Error al obtener las noticias"))
        }
    }
}
