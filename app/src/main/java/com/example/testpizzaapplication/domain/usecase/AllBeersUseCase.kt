package com.example.testpizzaapplication.domain.usecase

import com.example.testpizzaapplication.domain.repository.BeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface AllBeersUseCase {
    operator fun invoke(): Observable<List<BeerEntity>>
}

class AllBeersUseCaseImpl @Inject constructor(
    private val beersRepository: BeersRepository
) : AllBeersUseCase {

    override fun invoke(): Observable<List<BeerEntity>> {
        return beersRepository.getAllBeers()
    }
}
