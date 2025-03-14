package presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import domain.model.OnePersonIngredient
import lasagnedinner.composeapp.generated.resources.Res
import lasagnedinner.composeapp.generated.resources.remove
import org.jetbrains.compose.resources.painterResource
import util.AppConstants

@Composable
fun IngredientsList(
    ingredients: List<OnePersonIngredient>,
    peopleCount: Int = 4,
    onAddIngredient: () -> Unit = {},
    onRemoveIngredient: () -> Unit = {},
) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier.padding(AppConstants.Size.paddingStandard),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Zutaten",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(AppConstants.Size.paddingDouble),
            )
            ingredients.forEach {
                IngredientItem(
                    ingredient = it,
                    peopleCount = peopleCount,
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth(),
            ) {
                IconButton(onClick = onRemoveIngredient, modifier = Modifier.size(AppConstants.Size.iconButtonSize)) {
                    Icon(painterResource(Res.drawable.remove), "Person entfernen")
                }
                Text(text = peopleCount.toString())
                IconButton(onClick = onAddIngredient, modifier = Modifier.size(AppConstants.Size.iconButtonSize)) {
                    Icon(Icons.Default.Add, "Person hinzufügen")
                }
            }
        }
    }
}
