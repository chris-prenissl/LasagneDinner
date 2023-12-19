package com.dinner.lasagnedinner.presentation.component

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
import androidx.compose.ui.tooling.preview.Preview
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.Ingredient
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme
import com.dinner.lasagnedinner.util.AppConstants

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
                        Ingredient(
                            "Tomato",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    imagePath = R.drawable.bruschetta,
                    steps = listOf(),
                    durationInMin = 20,
                ),
                Dish(
                    title = "Lasagne",
                    ingredients =
                    listOf(
                        Ingredient(
                            "Tomato",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    imagePath = R.drawable.lasagne,
                    steps = listOf(),
                    durationInMin = 90,
                ),
                Dish(
                    title = "Flammbierte Bananen",
                    ingredients =
                    listOf(
                        Ingredient(
                            "Bananen",
                            3.0f,
                            IngredientType.Amount,
                        ),
                    ),
                    imagePath = R.drawable.flambananen,
                    steps = listOf(),
                    durationInMin = 20,
                ),
            ),
            onDishClicked = {},
        )
    }
}
