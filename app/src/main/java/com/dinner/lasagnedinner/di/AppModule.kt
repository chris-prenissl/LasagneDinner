package com.dinner.lasagnedinner.di

import com.dinner.lasagnedinner.data.repository.RecipeRepositoryImpl
import com.dinner.lasagnedinner.domain.repository.RecipeRepository
import com.dinner.lasagnedinner.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule =
    module {
        single<RecipeRepository> { RecipeRepositoryImpl() }
        viewModel { MainViewModel(get()) }
    }
