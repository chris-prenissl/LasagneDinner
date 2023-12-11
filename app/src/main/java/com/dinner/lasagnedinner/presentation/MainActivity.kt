package com.dinner.lasagnedinner.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.dinner.lasagnedinner.presentation.component.Dishes
import com.dinner.lasagnedinner.presentation.component.Recipe
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val selectedDish = viewModel.selectedDish.value
            if (selectedDish != null) {
                Recipe(dish = selectedDish)
            } else {
                Dishes(
                    dishes = viewModel.dishes,
                    onDishClicked = {
                        viewModel.setDish(it)
                    }
                )
            }
        }
    }
}

