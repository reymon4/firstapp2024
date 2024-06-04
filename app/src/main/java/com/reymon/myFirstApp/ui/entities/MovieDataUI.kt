package com.reymon.myFirstApp.ui.entities

import com.reymon.myFirstApp.data.network.entities.tmdb.Videos
import com.reymon.myFirstApp.data.network.entities.tmdb.Movie

data class MovieDataUI(
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val vote_average: Double,
    val videos: Videos,
    val poster_path: String,
){

}