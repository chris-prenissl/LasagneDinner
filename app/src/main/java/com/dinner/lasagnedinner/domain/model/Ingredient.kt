package com.dinner.lasagnedinner.domain.model

data class Ingredient(
    val title: String,
    val value: Float,
    val type: IngredientType,
)

enum class IngredientType(val unit: String? = null) {
    Gram("g"),
    Milliliter("ml"),
    Amount("Stück"),
    Truss("Bündel"),
    Skosh("Prise"),
}
