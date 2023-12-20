package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.domain.model.OnePersonIngredient
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipe(
    dish: Dish?,
    peopleCount: Int = 4,
    onAddIngredient: () -> Unit = {},
    onRemoveIngredient: () -> Unit = {},
    onBackButtonPress: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackButtonPress) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = {
                    Text(dish?.title ?: "")
                },
            )
        },
    ) { padding ->
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
                            peopleCount = peopleCount,
                            onAddIngredient = onAddIngredient,
                            onRemoveIngredient = onRemoveIngredient,
                        )
                    }

                    items(dish.steps) {
                        StepItem(dishStep = it)
                    }

                    item {
                        Spacer(
                            modifier = Modifier.size(
                                width = 0.dp,
                                height = 40.dp,
                            ),
                        )
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
                    OnePersonIngredient(
                        title = "Tomatoes",
                        value = 10.0f,
                        type = IngredientType.Amount,
                    ),
                    OnePersonIngredient(
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
