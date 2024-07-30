package presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.model.Dish
import domain.repository.RecipeRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    recipeRepository: RecipeRepository,
) : ViewModel() {
    val dishes = recipeRepository.getAllRecipes()

    private val _peopleCount = MutableStateFlow(4)
    val peopleCount = _peopleCount.asStateFlow()

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

    fun addPerson() {
        if (_peopleCount.value < 8) {
            _peopleCount.update { it.plus(1) }
        }
    }

    fun removePerson() {
        if (_peopleCount.value > 1) {
            _peopleCount.update { it.minus(1) }
        }
    }
}
