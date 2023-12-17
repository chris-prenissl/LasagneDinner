package com.dinner.lasagnedinner.presentation.component

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
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
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
import com.dinner.lasagnedinner.util.AppConstants
import com.dinner.lasagnedinner.util.toMinuteString

@Composable
fun DishItem(
    dish: Dish,
    onDishClicked: (Dish) -> Unit = {},
) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors = CardDefaults.cardColors(
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
                painter = painterResource(id = dish.imagePath),
                contentDescription = dish.title,
                modifier =
                Modifier
                    .clipToBounds()
                    .padding(4.dp),
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
                    imageVector = Icons.Default.Timelapse,
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

@Preview
@Composable
fun DishPreview() {
    val dish =
        Dish(
            title = "Lasagne",
            ingredients = emptyList(),
            imagePath = R.drawable.lasagne,
            steps = listOf(),
            durationInMin = 90,
        )
    LasagneDinnerTheme {
        DishItem(dish)
    }
}
