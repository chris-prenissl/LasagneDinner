package com.dinner.lasagnedinner.domain.repository

import com.dinner.lasagnedinner.domain.model.Dish

interface RecipeRepository {

    fun getRecipe(title: String): Dish?
    fun getAllRecipes(): List<Dish>
}