package com.christophprenissl.lasagnedinner

import android.app.Application
import di.initKoin

class LasagneDinnerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}
