package util

sealed class Screen(val route: String) {
    data object Dishes : Screen(route = "dishes")

    data object DishRecipe : Screen(route = "dish_recipe")
}
