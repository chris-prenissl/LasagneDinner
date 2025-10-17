package presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.Dish
import org.jetbrains.compose.resources.imageResource
import util.AppConstants
import util.toMinuteString

@Composable
fun DishItem(
    dish: Dish,
    onDishClicked: (Dish) -> Unit = {},
) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors =
            CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
        modifier =
            Modifier
                .clickable { onDishClicked(dish) }
                .padding(AppConstants.Size.paddingStandard),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = dish.title,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(AppConstants.Size.paddingStandard),
            )
            Image(
                bitmap = imageResource(dish.image),
                contentDescription = dish.title,
                modifier = Modifier.padding(AppConstants.Size.paddingStandard),
            )
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(AppConstants.Size.paddingStandard),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.List,
                    contentDescription = "Duration of ${dish.durationInMin.toMinuteString()}",
                )
                Spacer(
                    modifier =
                        Modifier.size(
                            width = AppConstants.Size.paddingHalf,
                            height = 0.dp,
                        ),
                )
                Text(
                    text = dish.durationInMin.toMinuteString(),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}
