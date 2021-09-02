package com.example.testpizzaapplication.domain.usecase

import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface AllBeersUseCase {
    operator fun invoke(): Single<List<BeerEntity>>
}

class AllBeersUseCaseImpl @Inject constructor(
    private val getBeersRepository: GetBeersRepository
) : AllBeersUseCase {

    override fun invoke(): Single<List<BeerEntity>> {
        return getBeersRepository.getAllBeers()
    }
}
