package com.dinner.lasagnedinner.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dinner.lasagnedinner.presentation.component.Dishes
import com.dinner.lasagnedinner.presentation.component.Recipe
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LasagneDinnerTheme {
                Scaffold(
                    modifier = Modifier.padding(8.dp)
                ) { padding ->
                    Surface {
                        val selectedDish = viewModel.selectedDish.value
                        if (selectedDish != null) {
                            Recipe(
                                dish = selectedDish,
                                padding = padding
                            )
                        } else {
                            Dishes(
                                dishes = viewModel.dishes,
                                onDishClicked = {
                                    viewModel.setDish(it)
                                },
                                padding = padding
                            )
                        }
                    }
                }
            }
        }
    }
}

