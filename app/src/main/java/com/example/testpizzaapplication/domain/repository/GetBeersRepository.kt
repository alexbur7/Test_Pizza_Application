package com.example.testpizzaapplication.domain.repository

import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Single

interface GetBeersRepository {

    fun getAllBeers(): Single<List<BeerEntity>>

    fun getStrongBeers(fortress: Float): Single<List<BeerEntity>>
}