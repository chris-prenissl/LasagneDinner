package presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
import org.jetbrains.compose.resources.imageResource
import util.AppConstants

@Composable
fun StepItem(dishStep: DishStep) {
    ElevatedCard(
        shape = ShapeDefaults.Medium,
        colors =
            CardDefaults.cardColors(
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
            )
            Text(
                text = dishStep.stepDescription,
                style = MaterialTheme.typography.bodyLarge,
                modifier =
                    Modifier
                        .background(color = MaterialTheme.colorScheme.secondaryContainer)
                        .padding(AppConstants.Size.paddingDouble),
            )
        }
    }
}
