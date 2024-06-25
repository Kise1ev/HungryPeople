package ru.kiselev.app.hungrypeople.models

import kotlinx.serialization.Serializable

@Serializable
data class Booking(
    val name: String,
    val email: String,
    val phone: String,
    val people: Int,
    val date: String,
    val time: String
)