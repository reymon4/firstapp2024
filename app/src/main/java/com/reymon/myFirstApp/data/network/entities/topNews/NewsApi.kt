package com.reymon.myFirstApp.data.network.entities.topNews

import com.reymon.myFirstApp.data.network.entities.topNews.Data


data class NewsApi(
    val `data`: List<Data>,
    val meta: Meta
)