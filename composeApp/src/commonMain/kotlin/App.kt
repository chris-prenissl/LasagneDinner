import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import presentation.MainViewModel
import presentation.component.Dishes
import presentation.component.Recipe
import presentation.style.LasagneDinnerTheme
import util.ObserveAsEvents
import util.Screen

@Composable
fun App(
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = koinViewModel(),
) {
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
                AnimatedVisibility(true) {
                    Dishes(
                        dishes = viewModel.dishes,
                        onDishClicked = viewModel::setDish,
                    )
                }
            }
            composable(Screen.DishRecipe.route) {
                AnimatedVisibility(true) {
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
