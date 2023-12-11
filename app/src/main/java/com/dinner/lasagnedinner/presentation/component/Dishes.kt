package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dinner.lasagnedinner.domain.model.Dish

@Composable
fun Dishes(
    dishes: List<Dish>
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        items(dishes) {
            DishItem(dish = it)
        }
    }
}