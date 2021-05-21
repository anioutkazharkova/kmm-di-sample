package com.azharkova.kmmdi.androidApp

import android.app.Application
import android.content.Context
import com.azharkova.kmmdi.shared.config.ConfigurationApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        val config = com.azharkova.kmmdi.shared.config.ConfigurationApp()
        val container = config.appContainer
        lateinit var INSTANCE: App
        var AppContext: Context? = null
    }
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        AppContext = this
    }
}
