package com.reymon.myFirstApp.logic.tmdb

import android.util.Log
import com.reymon.myFirstApp.data.network.endpoints.NewsEndpoint
import com.reymon.myFirstApp.data.network.endpoints.TopRatedEndpoint
import com.reymon.myFirstApp.data.network.entities.tmdb.Movie
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.TopRated
import com.reymon.myFirstApp.data.network.repository.RetrofitBase
import com.reymon.myFirstApp.ui.core.toNewsDataUI
import com.reymon.myFirstApp.ui.entities.MovieDataUI
import com.reymon.myFirstApp.ui.entities.NewsDataUI
import java.lang.Exception
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.Result as ResultMovie

class GetAllTopRatedUsercase {
    suspend operator fun invoke(): Result<List<ResultMovie>?> {
        var items = mutableListOf<ResultMovie>()
        var response = RetrofitBase.returnBaseRetrofitTMDB()
            .create(TopRatedEndpoint::class.java)
            .getAllTop()

        return if (response.isSuccessful) {
            response.body()?.results?.forEach() {
                items.add(
                    it
                )
            }
            Log.d("API", "Se ha conectado con la API")
            Log.d("API", items.toString())
            Result.success(items.toList())
        } else {
            Result.failure(Exception("Error al conectar con la API"))
        }
    }
}