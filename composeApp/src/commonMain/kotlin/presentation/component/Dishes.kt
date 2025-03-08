package presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import domain.model.Dish
import util.AppConstants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dishes(
    dishes: List<Dish>,
    onDishClicked: (Dish) -> Unit = {},
    onPrivacyPolicyClicked: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(AppConstants.Meta.APP_NAME)
                },
            )
        },
        contentWindowInsets = WindowInsets.safeContent,
    ) { padding ->
        Box {
            Surface(
                color = MaterialTheme.colorScheme.background,
            ) {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = padding,
                    modifier =
                    Modifier
                        .fillMaxSize(),
                ) {
                    items(dishes) {
                        DishItem(
                            dish = it,
                            onDishClicked = onDishClicked,
                        )
                    }
                }
            }
            Text(
                text = "Datenschutzerklärung",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center,
                ),
                modifier = Modifier.fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background)
                    .clickable(onClick = onPrivacyPolicyClicked)
                    .padding(AppConstants.Size.paddingStandard)
                    .align(Alignment.BottomCenter),
            )
        }
    }
}
