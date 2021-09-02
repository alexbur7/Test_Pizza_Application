package com.example.testpizzaapplication.di

import android.content.Context
import com.example.testpizzaapplication.di.module.BindsModule
import com.example.testpizzaapplication.di.module.DatabaseModule
import com.example.testpizzaapplication.di.module.NetworkModule
import com.example.testpizzaapplication.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        BindsModule::class,
        ViewModelModule::class,
        DatabaseModule::class
    ]
)
interface AppComponent : InjectFragments {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}