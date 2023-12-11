package com.dinner.lasagnedinner.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.repository.RecipeRepository

class MainViewModel(
    recipeRepository: RecipeRepository
) : ViewModel() {

    val dishes = recipeRepository.getAllRecipes()
    private val _selectedDish = mutableStateOf<Dish?>(null)
    val selectedDish: State<Dish?> = _selectedDish

    fun setDish(dish: Dish) {
        _selectedDish.value = dish
    }

    fun resetDish() {
        _selectedDish.value = null
    }
}