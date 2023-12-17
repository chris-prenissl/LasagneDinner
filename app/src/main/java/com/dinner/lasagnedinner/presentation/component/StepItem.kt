package com.dinner.lasagnedinner.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.dinner.lasagnedinner.domain.model.DishStep

@Composable
fun StepItem(dishStep: DishStep) {
    Column {
        Image(
            painter =
            painterResource(
                id = dishStep.imagePath,
            ),
            contentDescription = dishStep.stepDescription,
        )
        Text(text = dishStep.stepDescription)
    }
}
