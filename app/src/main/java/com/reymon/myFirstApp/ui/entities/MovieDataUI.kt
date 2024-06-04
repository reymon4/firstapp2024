package com.reymon.myFirstApp.ui.entities

import com.reymon.myFirstApp.data.network.entities.tmdb.Videos
import com.reymon.myFirstApp.data.network.entities.tmdb.Movie

class MovieDataUI(
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val videos: Videos,
)