package com.dinner.lasagnedinner.domain.model

data class UncountableIngredient(
    override val title: String,
    override val value: Float
): Ingredient<Float>(title, value)
