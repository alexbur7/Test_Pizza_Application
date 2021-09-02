package com.example.testpizzaapplication.domain.repository

import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface GetBeersRepository {

    fun getAllBeers(): Observable<List<BeerEntity>>

    fun getStrongBeers(fortress: Float): Observable<List<BeerEntity>>
}