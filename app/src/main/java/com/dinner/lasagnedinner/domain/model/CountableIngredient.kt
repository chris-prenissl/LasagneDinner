package com.dinner.lasagnedinner.domain.model

data class CountableIngredient(
    override val title: String,
    override val value: Int
): Ingredient<Int>(title, value)
