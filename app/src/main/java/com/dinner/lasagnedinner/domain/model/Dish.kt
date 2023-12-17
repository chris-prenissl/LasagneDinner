package com.dinner.lasagnedinner.domain.model

data class Dish(
    val title: String,
    val ingredients: List<Ingredient>,
    val imagePath: Int,
    val steps: List<DishStep>,
    val durationInMin: Int,
)
