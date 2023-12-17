package com.dinner.lasagnedinner.domain.model

open class Ingredient<T : Number>(
    open val title: String,
    open val value: T,
    open val type: IngredientType,
)

enum class IngredientType(val unit: String? = null) {
    Gram("g"),
    Milliliter("ml"),
    Amount("st"),
}
