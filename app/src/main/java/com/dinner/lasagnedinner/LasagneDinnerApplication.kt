package com.dinner.lasagnedinner

import android.app.Application
import com.dinner.lasagnedinner.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LasagneDinnerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@LasagneDinnerApplication)
            modules(appModule)
        }
    }
}
