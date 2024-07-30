package util

import androidx.compose.ui.unit.dp

sealed class AppConstants {
    object Meta {
        const val APP_NAME = "Lasagne Dinner"
    }
    object Size {
        val paddingDouble = 16.dp
        val paddingStandard = 8.dp
        val paddingHalf = 4.dp
        val listBottomSpace = 60.dp
    }
}
