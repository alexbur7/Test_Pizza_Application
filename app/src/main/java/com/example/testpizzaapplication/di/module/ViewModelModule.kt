package com.example.testpizzaapplication.di.module

import androidx.lifecycle.ViewModel
import com.example.testpizzaapplication.di.ViewModelKey
import com.example.testpizzaapplication.presentation.menu.MenuViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(MenuViewModel::class)]
    fun bindMenuViewModel(menuViewModel: MenuViewModel): ViewModel
}