package com.dinner.lasagnedinner.domain.model

data class UncountableIngredient(
    override val title: String,
    override val value: Float,
    override val type: IngredientType,
) : Ingredient<Float>(title, value, type)
