package com.ripalay.donut

import android.app.Application
import com.ripalay.donut.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
        androidContext(this@App)
        modules(koinModules)
        }
    }
}