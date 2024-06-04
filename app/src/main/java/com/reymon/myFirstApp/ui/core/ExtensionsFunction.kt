package com.reymon.myFirstApp.ui.core

import com.reymon.myFirstApp.data.network.entities.tmdb.Movie
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

/*fun Movie.toMovieDataUI(): MovieDataUI {
    return MovieDataUI(
        this.id,
        this.title,
        this.overview,
        this.release_date,
        this.videos,
        this.vote_average
    )
}*/

