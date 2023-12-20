package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dinner.lasagnedinner.R
import com.dinner.lasagnedinner.domain.model.DishStep
import com.dinner.lasagnedinner.presentation.style.LasagneDinnerTheme
import com.dinner.lasagnedinner.util.AppConstants

@Composable
fun StepItem(dishStep: DishStep) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier =
        Modifier
            .padding(AppConstants.Size.paddingStandard),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = dishStep.title,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(AppConstants.Size.paddingStandard),
            )
            AsyncImage(
                model = dishStep.imagePath,
                contentDescription = dishStep.title,
                modifier =
                Modifier
                    .clipToBounds()
                    .padding(4.dp),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppConstants.Size.paddingStandard),
            ) {
                Text(
                    text = dishStep.stepDescription,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(horizontal = AppConstants.Size.paddingStandard),
                )
            }
        }
    }
}

@Preview
@Composable
fun StepItemPreview() {
    LasagneDinnerTheme {
        StepItem(
            dishStep = DishStep(
                imagePath = R.drawable.schritt1,
                title = "Step 19",
                stepDescription = "Do this and that",
            ),
        )
    }
}
