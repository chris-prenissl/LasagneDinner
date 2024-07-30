package domain.model

import org.jetbrains.compose.resources.DrawableResource

data class Dish(
    val title: String,
    val ingredients: List<OnePersonIngredient>,
    val image: DrawableResource,
    val steps: List<DishStep>,
    val durationInMin: Int,
)
