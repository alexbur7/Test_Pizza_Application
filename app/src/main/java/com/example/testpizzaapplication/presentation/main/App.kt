package com.example.testpizzaapplication.presentation.main

import android.app.Application
import android.content.Context
import com.example.testpizzaapplication.di.AppComponent
import com.example.testpizzaapplication.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this.applicationContext)
            .build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
