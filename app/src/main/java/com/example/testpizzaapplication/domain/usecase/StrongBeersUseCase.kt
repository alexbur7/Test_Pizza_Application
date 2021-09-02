package com.example.testpizzaapplication.domain.usecase

import com.example.testpizzaapplication.domain.repository.BeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface StrongBeersUseCase {
    operator fun invoke(fortress: Float): Observable<List<BeerEntity>>
}

class StrongBeersUseCaseImpl @Inject constructor(
    private val beersRepository: BeersRepository
) : StrongBeersUseCase {

    override fun invoke(fortress: Float): Observable<List<BeerEntity>> {
        return beersRepository.getStrongBeers(fortress)
    }
}
