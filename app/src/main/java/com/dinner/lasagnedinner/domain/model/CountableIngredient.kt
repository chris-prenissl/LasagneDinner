package com.dinner.lasagnedinner.domain.model

data class CountableIngredient(
    override val title: String,
    override val value: Int,
    override val type: IngredientType,
) : Ingredient<Int>(title, value, type)
