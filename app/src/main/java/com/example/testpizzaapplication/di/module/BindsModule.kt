package com.example.testpizzaapplication.di.module

import com.example.testpizzaapplication.data.repository.GetBeersRepositoryImpl
import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.domain.usecase.AllBeersUseCase
import com.example.testpizzaapplication.domain.usecase.AllBeersUseCaseImpl
import com.example.testpizzaapplication.domain.usecase.StrongBeersUseCase
import com.example.testpizzaapplication.domain.usecase.StrongBeersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindGetBeerRepository(getBeersRepositoryImpl: GetBeersRepositoryImpl): GetBeersRepository

    @Binds
    fun bindGetBeersUseCase(getRepositoryUseCaseImp: AllBeersUseCaseImpl): AllBeersUseCase

    @Binds
    fun bindGetStrongBeersUseCase(getStrongBeersUseCaseImpl: StrongBeersUseCaseImpl)
            : StrongBeersUseCase
}
