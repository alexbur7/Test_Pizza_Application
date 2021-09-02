package com.example.testpizzaapplication.data.repository

import com.example.testpizzaapplication.data.mapper.BeerApiToBeerEntityMapper
import com.example.testpizzaapplication.data.service.AppService
import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetBeersRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val beerMapper: BeerApiToBeerEntityMapper
) : GetBeersRepository {

    override fun getAllBeers(): Single<List<BeerEntity>> {
        return appService.getAllBeers()
            .map { beers ->
                beers.map(beerMapper)
            }
    }

    override fun getStrongBeers(fortress: Float): Single<List<BeerEntity>> {
        return appService.getStrongBeers(fortress)
            .map { beers ->
                beers.sortedBy { it.fortress }.map(beerMapper)
            }
    }
}