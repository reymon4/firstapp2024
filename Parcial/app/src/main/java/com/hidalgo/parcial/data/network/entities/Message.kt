package com.hidalgo.parcial.data.network.entities

data class Message(
    val meta: Meta,
    val resultMessages: List<ResultMessage>
)