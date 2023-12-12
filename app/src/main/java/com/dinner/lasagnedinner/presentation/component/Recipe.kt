package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.CountableIngredient
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.domain.model.UncountableIngredient

@Composable
fun Recipe(
    dish: Dish,
    padding: PaddingValues
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        contentPadding = padding
    ) {
        item {
            Text(dish.title)
        }

        items(dish.ingredients) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = it.title)
                Text(text = it.value.toString())
            }
        }

        items(dish.steps) {
            Image(
                painter = painterResource(id = it.imagePath),
                contentDescription = it.stepDescription
            )
            Text(it.stepDescription)
        }
    }
}

@Preview
@Composable
fun RecipePreview() {
   Recipe(
       dish = Dish(
           title = "Lasagne",
           ingredients = listOf(
               CountableIngredient(
                   title = "Tomatoes",
                   value = 10
               ),
               UncountableIngredient(
                   title = "Meat",
                   value = 300.0f
               )
           ),
           imagePath = R.drawable.lasagne,
           steps = listOf(
               DishStep(
                   imagePath = R.drawable.schritt6,
                   stepDescription = "First Step"
               ),
               DishStep(
                   imagePath = R.drawable.schritt10,
                   stepDescription = "Second Step"
               )
           )
       ),
       padding = PaddingValues()
   )
}