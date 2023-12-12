package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.Dish
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme

@Composable
fun DishItem(
    dish: Dish,
    onDishClicked: (Dish) -> Unit = {}
) {
    Card(
        shape = ShapeDefaults.Medium,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = dish.title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleLarge,
            )
            Image(
                painter = painterResource(id = dish.imagePath),
                contentDescription = dish.title,
                modifier = Modifier
                    .clipToBounds()
                    .padding(4.dp)
                    .clickable { onDishClicked(dish) }
            )
        }
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
    LasagneDinnerTheme {
        DishItem(dish)
    }
}