package com.dinner.lasagnedinner.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dinner.lasagnedinner.presentation.component.Dishes
import com.dinner.lasagnedinner.presentation.component.Recipe
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme
import com.dinner.lasagnedinner.util.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val peopleCountState = viewModel.peopleCount.collectAsState()

            LasagneDinnerTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Dishes.route,
                ) {
                    composable(Screen.Dishes.route) {
                        ObserveAsEvents(
                            flow = viewModel.didSelectDishChannelFlow,
                        ) { didSelect ->
                            if (didSelect) {
                                navController.navigate(Screen.DishRecipe.route)
                            } else {
                                navController.navigate(Screen.Dishes.route)
                            }
                        }
                        Dishes(
                            dishes = viewModel.dishes,
                            onDishClicked = viewModel::setDish,
                        )
                    }
                    composable(Screen.DishRecipe.route) {
                        Recipe(
                            dish = viewModel.selectedDish,
                            peopleCount = peopleCountState.value,
                            onAddIngredient = viewModel::addPerson,
                            onRemoveIngredient = viewModel::removePerson,
                            onBackButtonPress = { navController.navigateUp() },
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun <T> ObserveAsEvents(
        flow: Flow<T>,
        onEvent: (T) -> Unit,
    ) {
        val lifecycleOwner = LocalLifecycleOwner.current
        LaunchedEffect(key1 = flow, lifecycleOwner.lifecycle) {
            lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                withContext(Dispatchers.Main.immediate) {
                    flow.collect(onEvent)
                }
            }
        }
    }
}
