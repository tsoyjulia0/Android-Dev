package com.example.dodo.model

import java.util.UUID

data class Pizza(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val price: Double,
    val image: Int,
)

