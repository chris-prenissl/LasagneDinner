package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.CountableIngredient
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.domain.model.UncountableIngredient
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme

@Composable
fun Recipe(dish: Dish?) {
    Scaffold { padding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                contentPadding = padding,
            ) {
                dish?.let {
                    item {
                        Text(
                            text = dish.title,
                            style = MaterialTheme.typography.headlineMedium,
                        )
                    }

                    item {
                        IngredientsList(
                            ingredients = it.ingredients,
                        )
                    }

                    items(dish.steps) {
                        StepItem(dishStep = it)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RecipePreview() {
    LasagneDinnerTheme {
        Recipe(
            dish =
            Dish(
                title = "Lasagne",
                ingredients =
                listOf(
                    CountableIngredient(
                        title = "Tomatoes",
                        value = 10,
                        type = IngredientType.Amount,
                    ),
                    UncountableIngredient(
                        title = "Meat",
                        value = 300.0f,
                        type = IngredientType.Gram,
                    ),
                ),
                imagePath = R.drawable.lasagne,
                steps =
                listOf(
                    DishStep(
                        imagePath = R.drawable.schritt6,
                        title = "First Step",
                        stepDescription = "First Step",
                    ),
                    DishStep(
                        imagePath = R.drawable.schritt10,
                        title = "Second",
                        stepDescription = "Second Step",
                    ),
                ),
                durationInMin = 90,
            ),
        )
    }
}
