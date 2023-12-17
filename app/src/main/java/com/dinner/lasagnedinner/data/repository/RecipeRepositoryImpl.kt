package com.dinner.lasagnedinner.data.repository

import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.repository.RecipeRepository

class RecipeRepositoryImpl : RecipeRepository {
    private val recipes =
        listOf(
            Dish(
                title = "Bruschetta",
                ingredients = emptyList(),
                imagePath = R.drawable.bruschetta,
                steps = emptyList(),
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
