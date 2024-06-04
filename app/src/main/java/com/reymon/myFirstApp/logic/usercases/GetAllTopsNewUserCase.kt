package com.reymon.myFirstApp.logic.usercases

import com.reymon.myFirstApp.data.network.endpoints.NewsEndpoint


import com.reymon.myFirstApp.data.network.repository.RetrofitBase
import com.reymon.myFirstApp.data.network.entities.topNews.Data
import com.reymon.myFirstApp.ui.core.toNewsDataUI
import com.reymon.myFirstApp.ui.entities.NewsDataUI

import java.lang.Exception

class GetAllTopsNewUserCase {

    //CCRREGIR EL NOMBRE DE LA FUNCIÓN DEL RESPONSE DE RETROFIT
    suspend operator fun invoke(): Result<List<NewsDataUI>?> {
        var items = mutableListOf<NewsDataUI>()
        var response = RetrofitBase.returnBaseRetrofitDB()
            .create(NewsEndpoint::class.java)
            .getAllTopNews()

        return if (response.isSuccessful) {
            response.body()?.data?.forEach {
                items.add(
                    it.toNewsDataUI()
                )
            }
            Result.success(items.toList())
        } else {
            Result.failure(Exception("Error al obtener las noticias"))
        }
    }
}
