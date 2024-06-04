package com.reymon.myFirstApp.ui.core

import com.reymon.myFirstApp.data.network.entities.topNews.Data
import com.reymon.myFirstApp.ui.entities.MovieDataUI
import com.reymon.myFirstApp.ui.entities.NewsDataUI

class ExtensionsFunction


fun Data.toNewsDataUI(): NewsDataUI {
    return NewsDataUI(
        this.uuid,
        this.title,
        this.description,
        this.url,
        this.image_url
    )
}

fun Data.toMovieDataUI(): MovieDataUI {
    return MovieDataUI(

    )
}

