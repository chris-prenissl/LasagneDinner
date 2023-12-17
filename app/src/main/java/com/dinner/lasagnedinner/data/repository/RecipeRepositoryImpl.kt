package com.dinner.lasagnedinner.data.repository

import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.domain.model.Ingredient
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.domain.repository.RecipeRepository

class RecipeRepositoryImpl : RecipeRepository {
    private val recipes =
        listOf(
            Dish(
                title = "Bruschetta",
                ingredients = listOf(
                    Ingredient(
                        title = "Tomaten",
                        value = 2.0f,
                        type = IngredientType.Amount,
                    ),
                    Ingredient(
                        title = "Zwiebeln",
                        value = 1.0f,
                        type = IngredientType.Amount,
                    ),
                    Ingredient(
                        title = "Olivenöl",
                        value = 30.0f,
                        type = IngredientType.Milliliter,
                    ),
                    Ingredient(
                        title = "Ciabatta",
                        value = 1.0f,
                        type = IngredientType.Amount,
                    ),
                    Ingredient(
                        title = "Basilikum",
                        value = 1.0f,
                        type = IngredientType.Truss,
                    ),
                    Ingredient(
                        title = "Knoblauchzehen",
                        value = 1.0f,
                        type = IngredientType.Amount,
                    ),
                    Ingredient(
                        title = "Salz",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                    Ingredient(
                        title = "Pfeffer",
                        value = 1.0f,
                        type = IngredientType.Skosh,
                    ),
                ),
                imagePath = R.drawable.bruschetta,
                steps = listOf(
                    DishStep(
                        imagePath = R.drawable.schritt1,
                        title = "Baguette Vorbereiten",
                        stepDescription = "Schneide das Ciabatta nach Belieben in Scheiben und reibe " +
                            "es mit einer halbierten Knoblauchzehe und Olivenöl gründlich ein.",
                    ),
                    DishStep(
                        imagePath = R.drawable.schritt2,
                        title = "Backofen Vorheizen",
                        stepDescription = "Heize den Backofen auf 150°C bei Ober-Unterhitze vor und " +
                            "lege die Ciabattascheiben auf einen mit Backpapier belegten Rost." +
                            " Die Scheiben müssen nun bis zur gewünschten Bräune und " +
                            "angenehmen Knoblauch-Duft für ca. 5-10 min. im Ofen bleiben.",
                    ),
                    DishStep(
                        imagePath = R.drawable.schritt3,
                        title = "Topping",
                        stepDescription = "Schneide nun die Zwiebeln und Tomaten in Würfel und das" +
                            " Basilikum in Streifen. Mische die Zutaten und würze die Masse " +
                            "mit Basilikum, Salz und Pfeffer.",
                    ),
                    DishStep(
                        imagePath = R.drawable.schritt4,
                        title = "Anrichten",
                        stepDescription = "Trage nun die Bruschettamasse auf die knusprig" +
                            " duftenden Ciabattascheiben auf. Nach Wunsch kann das Topping" +
                            " noch mit Olivenöl beträufelt werden.Das Gericht" +
                            " lässt sich gut mit Prosecco zu einem Gruß aus der Küche kombinieren.",
                    ),
                ),
                durationInMin = 20,
            ),
            Dish(
                title = "Lasagne",
                ingredients = emptyList(),
                imagePath = R.drawable.lasagne,
                steps = emptyList(),
                durationInMin = 90,
            ),
            Dish(
                title = "Flammbierte Bananen",
                ingredients = emptyList(),
                imagePath = R.drawable.flambananen,
                steps = emptyList(),
                durationInMin = 20,
            ),
        )

    override fun getRecipe(title: String): Dish? {
        return recipes.firstOrNull { it.title == title }
    }

    override fun getAllRecipes(): List<Dish> {
        return recipes
    }
}
