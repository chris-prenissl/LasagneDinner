package presentation.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.Dish
import domain.model.IngredientType
import domain.model.OnePersonIngredient
import lasagnedinner.composeapp.generated.resources.Res
import lasagnedinner.composeapp.generated.resources.bruschetta
import lasagnedinner.composeapp.generated.resources.flambananen
import lasagnedinner.composeapp.generated.resources.lasagne
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.style.LasagneDinnerTheme
import util.AppConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dishes(
    dishes: List<Dish>,
    onDishClicked: (Dish) -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(AppConstants.Meta.APP_NAME)
                },
            )
        },
        contentWindowInsets = WindowInsets.safeContent,
    ) { padding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                contentPadding = padding,
                modifier =
                Modifier
                    .fillMaxSize(),
            ) {
                items(dishes) {
                    DishItem(
                        dish = it,
                        onDishClicked = onDishClicked,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DishesPreview() {
    LasagneDinnerTheme {
        Dishes(
            dishes =
            listOf(
                Dish(
                    title = "Bruschetta",
                    ingredients =
                    listOf(
                        OnePersonIngredient(
                            "Tomato",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    image = Res.drawable.bruschetta,
                    steps = listOf(),
                    durationInMin = 20,
                ),
                Dish(
                    title = "Lasagne",
                    ingredients =
                    listOf(
                        OnePersonIngredient(
                            "Tomato",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    image = Res.drawable.lasagne,
                    steps = listOf(),
                    durationInMin = 90,
                ),
                Dish(
                    title = "Flammbierte Bananen",
                    ingredients =
                    listOf(
                        OnePersonIngredient(
                            "Bananen",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    image = Res.drawable.flambananen,
                    steps = listOf(),
                    durationInMin = 20,
                ),
            ),
            onDishClicked = {},
        )
    }
}
