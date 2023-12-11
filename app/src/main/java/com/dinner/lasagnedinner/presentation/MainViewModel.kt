package com.dinner.lasagnedinner.presentation

import androidx.lifecycle.ViewModel
import com.dinner.lasagnedinner.domain.repository.RecipeRepository

class MainViewModel(
    recipeRepository: RecipeRepository
) : ViewModel() {

    val dishes = recipeRepository.getAllRecipes()
}