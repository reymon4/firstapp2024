package com.reymon.myFirstApp.data.network.entities

data class Character(
    val affiliation: String?="",

    val description: String?="",
    val gender: String?="",
    val id: Int?=0,
    val image: String?="",
    val ki: String?="",
    val maxKi: String?="",
    val name: String?="",
    val originPlanet: OriginPlanet?=null,
    val race: String?="",
    val transformations: List<Transformation>?= null
)