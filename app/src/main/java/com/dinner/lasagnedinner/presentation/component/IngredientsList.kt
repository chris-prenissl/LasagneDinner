package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinner.lasagnedinner.domain.model.CountableIngredient
import com.dinner.lasagnedinner.domain.model.Ingredient
import com.dinner.lasagnedinner.domain.model.IngredientType
import com.dinner.lasagnedinner.domain.model.UncountableIngredient
import com.dinner.lasagnedinner.presentation.style.typography
import com.dinner.lasagnedinner.util.AppConstants

@Composable
fun IngredientsList(
    ingredients: List<Ingredient<*>>,
) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier.padding(AppConstants.Size.paddingStandard),
    ) {
        Column {
            Text(
                text = "Zutaten",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(AppConstants.Size.paddingDouble),
            )
            ingredients.forEach {
                IngredientItem(ingredient = it)
            }
        }
    }
}

@Preview
@Composable
fun IngredientsListPreview() {
    IngredientsList(
        ingredients = listOf(
            CountableIngredient(
                title = "Tomatoes",
                value = 4,
                type = IngredientType.Amount,
            ),
            UncountableIngredient(
                title = "Meat",
                value = 400.0f,
                type = IngredientType.Gram,
            ),
        ),
    )
}
