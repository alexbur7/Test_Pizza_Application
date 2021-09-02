package com.example.testpizzaapplication.domain.usecase

import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface StrongBeersUseCase {
    operator fun invoke(fortress: Float): Single<List<BeerEntity>>
}

class StrongBeersUseCaseImpl @Inject constructor(
    private val getBeersRepository: GetBeersRepository
) : StrongBeersUseCase {

    override fun invoke(fortress: Float): Single<List<BeerEntity>> {
        return getBeersRepository.getStrongBeers(fortress)
    }

}