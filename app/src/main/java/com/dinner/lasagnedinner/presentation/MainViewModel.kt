package com.dinner.lasagnedinner.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.repository.RecipeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel(
    recipeRepository: RecipeRepository,
) : ViewModel() {
    val dishes = recipeRepository.getAllRecipes()

    private val didSelectDishChannel = Channel<Boolean>()
    val didSelectDishChannelFlow = didSelectDishChannel.receiveAsFlow()

    var selectedDish: Dish? = null

    fun setDish(dish: Dish) {
        selectedDish = dish
        viewModelScope.launch {
            didSelectDishChannel.send(true)
        }
    }

    fun unselectDish() {
        selectedDish = null
        viewModelScope.launch {
            didSelectDishChannel.send(false)
        }
    }
}
