package domain.repository

import domain.model.Dish

interface RecipeRepository {
    fun getRecipe(title: String): Dish?

    fun getAllRecipes(): List<Dish>
}
