package com.example.testpizzaapplication.domain.usecase

import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface AllBeersUseCase {
    operator fun invoke(): Observable<List<BeerEntity>>
}

class AllBeersUseCaseImpl @Inject constructor(
    private val getBeersRepository: GetBeersRepository
) : AllBeersUseCase {

    override fun invoke(): Observable<List<BeerEntity>> {
        return getBeersRepository.getAllBeers()
    }
}
