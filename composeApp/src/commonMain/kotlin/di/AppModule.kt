package di

import data.repository.RecipeRepositoryImpl
import domain.repository.RecipeRepository
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import presentation.MainViewModel

private val appModule = module {
    single<RecipeRepository> { RecipeRepositoryImpl() }

    viewModel { MainViewModel(get()) }
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}
