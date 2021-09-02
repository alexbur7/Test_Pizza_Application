package com.example.testpizzaapplication.data.db.source

import com.example.testpizzaapplication.data.db.dao.BeersDao
import com.example.testpizzaapplication.data.mapper.BeerDbToBeerEntityMapper
import com.example.testpizzaapplication.data.mapper.BeerEntityToBeerDbMapper
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface BeersDbSource {

    fun getAllBeers(): Observable<List<BeerEntity>>

    fun getStrongBeers(fortress: Float): Observable<List<BeerEntity>>

    fun insertBeers(beers: List<BeerEntity>)
}

class BeersDbSourceImpl @Inject constructor(
    private val beersDao: BeersDao,
    private val beerDbToEntityMapper: BeerDbToBeerEntityMapper,
    private val beerEntityMapper: BeerEntityToBeerDbMapper
) : BeersDbSource {

    override fun getAllBeers(): Observable<List<BeerEntity>> {
        return beersDao.getAllBeers()
            .map { beers ->
                beers.map(beerDbToEntityMapper)
            }
            .toObservable()
    }

    override fun getStrongBeers(fortress: Float): Observable<List<BeerEntity>> {
        return beersDao.getStrongBeers(fortress)
            .map { beers ->
                beers.map(beerDbToEntityMapper)
            }
            .toObservable()
    }

    override fun insertBeers(beers: List<BeerEntity>) {
        beersDao.insertBeers(
            beers.map(beerEntityMapper)
        )
    }

}