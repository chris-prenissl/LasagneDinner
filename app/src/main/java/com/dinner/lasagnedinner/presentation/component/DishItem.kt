package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish

@Composable
fun DishItem(
    dish: Dish,
    onDishClicked: (Dish) -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(dish.title)
        Image(
            painter = painterResource(id = dish.imagePath),
            contentDescription = dish.title,
            modifier = Modifier.clickable { onDishClicked(dish) }
        )
    }
}

@Preview
@Composable
fun DishPreview() {
    val dish = Dish(
        title = "Lasagne",
        ingredients = emptyList(),
        imagePath = R.drawable.lasagne,
        steps = listOf()
    )
    DishItem(dish)
}