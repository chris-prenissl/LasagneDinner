package presentation.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.Dish

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipe(
    dish: Dish?,
    peopleCount: Int = 4,
    onAddIngredient: () -> Unit = {},
    onRemoveIngredient: () -> Unit = {},
    onBackButtonPress: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = onBackButtonPress) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                },
                title = {
                    Text(dish?.title ?: "")
                },
            )
        },
    ) { padding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
                contentPadding = padding,
            ) {
                dish?.let {
                    item {
                        Text(
                            text = dish.title,
                            style = MaterialTheme.typography.headlineMedium,
                        )
                    }

                    item {
                        IngredientsList(
                            ingredients = it.ingredients,
                            peopleCount = peopleCount,
                            onAddIngredient = onAddIngredient,
                            onRemoveIngredient = onRemoveIngredient,
                        )
                    }

                    items(dish.steps) {
                        StepItem(dishStep = it)
                    }

                    item {
                        Spacer(
                            modifier =
                                Modifier.size(
                                    width = 0.dp,
                                    height = 40.dp,
                                ),
                        )
                    }
                }
            }
        }
    }
}
