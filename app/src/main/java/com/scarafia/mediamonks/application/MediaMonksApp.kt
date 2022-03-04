package com.scarafia.mediamonks.application

import android.app.Application
import com.scarafia.mediamonks.application.di.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin


class MediaMonksApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MediaMonksApp)
            modules(modulesList)
        }
    }
}