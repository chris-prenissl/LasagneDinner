package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dinner.lasagnedinner.domain.model.CountableIngredient
import com.dinner.lasagnedinner.domain.model.Ingredient
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.util.AppConstants

@Composable
fun IngredientItem(
    ingredient: Ingredient<*>,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppConstants.Size.paddingDouble,
                vertical = AppConstants.Size.paddingStandard,
            ),
    ) {
        Text(text = ingredient.title)
        Row {
            Text(text = ingredient.value.toString())
            ingredient.type.unit?.let {
                Spacer(
                    modifier = Modifier.size(
                        width = AppConstants.Size.paddingHalf,
                        height = 0.dp,
                    ),
                )
                Text(text = it)
            }
        }
    }
}

@Preview
@Composable
fun IngredientItemPreview() {
    IngredientItem(
        ingredient = CountableIngredient(
            title = "Tomatoes",
            value = 20,
            type = IngredientType.Amount,
        ),
    )
}
