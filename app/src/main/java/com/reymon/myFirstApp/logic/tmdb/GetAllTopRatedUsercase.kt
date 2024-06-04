package com.reymon.myFirstApp.logic.tmdb

import android.util.Log
import com.reymon.myFirstApp.data.network.endpoints.NewsEndpoint
import com.reymon.myFirstApp.data.network.endpoints.TopRatedEndpoint
import com.reymon.myFirstApp.data.network.repository.RetrofitBase
import com.reymon.myFirstApp.ui.core.toNewsDataUI
import com.reymon.myFirstApp.ui.entities.MovieDataUI
import com.reymon.myFirstApp.ui.entities.NewsDataUI
import java.lang.Exception

class GetAllTopRatedUsercase {
    suspend operator fun invoke(): Result<List<NewsDataUI>?> {
        var items = mutableListOf<NewsDataUI>()
        var response = RetrofitBase.returnBaseRetrofitTMDB()
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