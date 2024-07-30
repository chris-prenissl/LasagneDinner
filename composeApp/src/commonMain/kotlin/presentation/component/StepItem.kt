package presentation.component

import androidx.compose.foundation.Image
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
import domain.model.DishStep
import lasagnedinner.composeapp.generated.resources.Res
import lasagnedinner.composeapp.generated.resources.schritt1
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.style.LasagneDinnerTheme
import util.AppConstants

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
            Image(
                bitmap = imageResource(dishStep.image),
                contentDescription = dishStep.title,
                modifier = Modifier.padding(AppConstants.Size.paddingStandard),
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
                image = Res.drawable.schritt1,
                title = "Step 19",
                stepDescription = "Do this and that",
            ),
        )
    }
}
