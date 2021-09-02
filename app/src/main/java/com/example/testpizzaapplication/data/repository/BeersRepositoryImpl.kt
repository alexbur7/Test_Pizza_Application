package com.example.testpizzaapplication.data.repository

import com.example.testpizzaapplication.data.db.source.BeersDbSource
import com.example.testpizzaapplication.data.service.source.BeersServiceSource
import com.example.testpizzaapplication.domain.repository.BeersRepository
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class BeersRepositoryImpl @Inject constructor(
    private val beersDbSource: BeersDbSource,
    private val beersServiceSource: BeersServiceSource
) : BeersRepository {

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
