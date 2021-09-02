package com.example.testpizzaapplication.data.repository

import com.example.testpizzaapplication.data.db.source.BeersDbSource
import com.example.testpizzaapplication.data.mapper.BeerApiToBeerEntityMapper
import com.example.testpizzaapplication.data.service.AppService
import com.example.testpizzaapplication.data.service.source.BeersServiceSource
import com.example.testpizzaapplication.domain.repository.GetBeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetBeersRepositoryImpl @Inject constructor(
    private val beersDbSource: BeersDbSource,
    private val beersServiceSource: BeersServiceSource
) : GetBeersRepository {

    override fun getAllBeers(): Observable<List<BeerEntity>> {
        return Observable.concat(
            beersDbSource.getAllBeers(),
            beersServiceSource.getAllBeers()
                .doOnNext {
                    beersDbSource.insertBeers(it)
                }
        )
    }

    override fun getStrongBeers(fortress: Float): Observable<List<BeerEntity>> {
        return Observable.concat(
            beersDbSource.getStrongBeers(fortress),
            beersServiceSource.getStrongBeers(fortress)
                .doOnNext {
                    beersDbSource.insertBeers(it)
                }
        )
    }
}