package domain.model

import org.jetbrains.compose.resources.DrawableResource

data class DishStep(
    val image: DrawableResource,
    val title: String,
    val stepDescription: String,
)
