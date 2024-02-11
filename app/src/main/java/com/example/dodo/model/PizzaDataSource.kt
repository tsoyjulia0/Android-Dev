package com.example.dodo.model

import com.example.dodo.R

object PizzaDataSource {
    val pizzas = arrayListOf<Pizza>(
        Pizza(
            image = R.drawable.cheesy,
            name = "Cheesy pizza",
            description = "Hot cheesy pizza with 4 types of cheese",
            price = 1800.0
        ),
        Pizza(
            image = R.drawable.bacon,
            name = "Bacon Grand pizza",
            description = "Hot pizza with extra bacon",
            price = 2100.0
        ),
        Pizza(
            image = R.drawable.peperoni,
            name = "Peperoni pizza",
            description = "Hot tasty peperoni pizza",
            price = 1850.0
        ),
        Pizza(
            image = R.drawable.pizza_dodomix,
            name = "Mix Dodo pizza",
            description = "Hot tasty pizza with 4 different types",
            price = 2100.0
        ),
        Pizza(
            image = R.drawable.bacon,
            name = "Bacon pizza",
            description = "Hot tasty pizza with fried salt bacon",
            price = 1900.0
        ),
        Pizza(
            image = R.drawable.cheesy,
            name = "Cheesy Grand pizza",
            description = "Hot pizza with extra cheese",
            price = 2000.0
        ),
    )
}