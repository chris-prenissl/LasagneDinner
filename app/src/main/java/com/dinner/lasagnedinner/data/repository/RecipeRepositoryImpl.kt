package com.dinner.lasagnedinner.data.repository

import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.CountableIngredient
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.domain.model.UncountableIngredient
import com.dinner.lasagnedinner.domain.repository.RecipeRepository

class RecipeRepositoryImpl : RecipeRepository {
    private val recipes =
        listOf(
            Dish(
                title = "Bruschetta",
                ingredients = listOf(
                    CountableIngredient(
                        title = "Tomaten",
                        value = 2,
                        type = IngredientType.Amount,
                    ),
                    CountableIngredient(
                        title = "Zwiebeln",
                        value = 1,
                        type = IngredientType.Amount,
                    ),
                    UncountableIngredient(
                        title = "Olivenöl",
                        value = 30.0f,
                        type = IngredientType.Milliliter,
                    ),
                    CountableIngredient(
                        title = "Baguette",
                        value = 1,
                        type = IngredientType.Amount,
                    ),
                    CountableIngredient(
                        title = "Basilikum",
                        value = 1,
                        type = IngredientType.Truss,
                    ),
                ),
                imagePath = R.drawable.bruschetta,
                steps = listOf(
                    DishStep(
                        imagePath = R.drawable.schritt1,
                        title = "Baguette Vorbereiten",
                        stepDescription = "Schneide das Ciabatta nach Belieben in Scheiben und reibe es mit einer halbierten Knoblauchzehe und Olivenöl gründlich ein.",
                    ),
                ),
                durationInMin = 30,
            ),
            Dish(
                title = "Lasagne",
                ingredients = emptyList(),
                imagePath = R.drawable.lasagne,
                steps = emptyList(),
                durationInMin = 90,
            ),
            Dish(
                title = "Flammbierte Bananen",
                ingredients = emptyList(),
                imagePath = R.drawable.flambananen,
                steps = emptyList(),
                durationInMin = 20,
            ),
        )

    override fun getRecipe(title: String): Dish? {
        return recipes.firstOrNull { it.title == title }
    }

    override fun getAllRecipes(): List<Dish> {
        return recipes
    }
}
