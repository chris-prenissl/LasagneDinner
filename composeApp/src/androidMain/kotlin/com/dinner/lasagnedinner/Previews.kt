package com.dinner.lasagnedinner

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import domain.model.Dish
import domain.model.DishStep
import domain.model.IngredientType
import domain.model.OnePersonIngredient
import lasagnedinner.composeapp.generated.resources.Res
import lasagnedinner.composeapp.generated.resources.bruschetta
import lasagnedinner.composeapp.generated.resources.flambananen
import lasagnedinner.composeapp.generated.resources.lasagne
import lasagnedinner.composeapp.generated.resources.schritt1
import lasagnedinner.composeapp.generated.resources.schritt10
import lasagnedinner.composeapp.generated.resources.schritt6
import presentation.component.DishItem
import presentation.component.Dishes
import presentation.component.IngredientItem
import presentation.component.IngredientsList
import presentation.component.Recipe
import presentation.component.StepItem
import presentation.style.LasagneDinnerTheme

@Preview
@Composable
fun DishPreview() {
    val dish =
        Dish(
            title = "Lasagne",
            ingredients = emptyList(),
            image = Res.drawable.lasagne,
            steps = listOf(),
            durationInMin = 90,
        )
    LasagneDinnerTheme {
        DishItem(dish)
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

@Preview
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        ingredient =
            OnePersonIngredient(
                title = "Tomatoes",
                value = 20.0f,
                type = IngredientType.Amount,
            ),
        peopleCount = 4,
    )
}

@Preview
@Composable
fun IngredientsListPreview() {
    IngredientsList(
        ingredients =
            listOf(
                OnePersonIngredient(
                    title = "Tomatoes",
                    value = 4.0f,
                    type = IngredientType.Amount,
                ),
                OnePersonIngredient(
                    title = "Meat",
                    value = 400.0f,
                    type = IngredientType.Gram,
                ),
            ),
    )
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
                    image = Res.drawable.lasagne,
                    steps =
                        listOf(
                            DishStep(
                                image = Res.drawable.schritt6,
                                title = "First Step",
                                stepDescription = "First Step",
                            ),
                            DishStep(
                                image = Res.drawable.schritt10,
                                title = "Second",
                                stepDescription = "Second Step",
                            ),
                        ),
                    durationInMin = 90,
                ),
        )
    }
}

@Preview
@Composable
fun StepItemPreview() {
    LasagneDinnerTheme {
        StepItem(
            dishStep =
                DishStep(
                    image = Res.drawable.schritt1,
                    title = "Step 19",
                    stepDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                ),
        )
    }
}
