package com.reymon.myFirstApp.data.network.entities.tmdb.rated

data class TopRated(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)