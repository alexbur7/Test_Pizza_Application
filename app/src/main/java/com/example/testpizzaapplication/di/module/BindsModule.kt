package com.example.testpizzaapplication.di.module

import com.example.testpizzaapplication.data.db.source.BeersDbSource
import com.example.testpizzaapplication.data.db.source.BeersDbSourceImpl
import com.example.testpizzaapplication.data.repository.BeersRepositoryImpl
import com.example.testpizzaapplication.data.service.source.BeersServiceSource
import com.example.testpizzaapplication.data.service.source.BeersServiceSourceImpl
import com.example.testpizzaapplication.domain.repository.BeersRepository
import com.example.testpizzaapplication.domain.usecase.AllBeersUseCase
import com.example.testpizzaapplication.domain.usecase.AllBeersUseCaseImpl
import com.example.testpizzaapplication.domain.usecase.StrongBeersUseCase
import com.example.testpizzaapplication.domain.usecase.StrongBeersUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindGetBeerRepository(getBeersRepositoryImpl: BeersRepositoryImpl): BeersRepository

    @Binds
    fun bindBeersUseCase(getRepositoryUseCaseImp: AllBeersUseCaseImpl): AllBeersUseCase

    @Binds
    fun bindStrongBeersUseCase(getStrongBeersUseCaseImpl: StrongBeersUseCaseImpl)
            : StrongBeersUseCase

    @Binds
    fun bindBeersDbSource(beersDbSourceImpl: BeersDbSourceImpl): BeersDbSource

    @Binds
    fun bindBeersServiceSource(beersServiceSourceImpl: BeersServiceSourceImpl): BeersServiceSource
}
