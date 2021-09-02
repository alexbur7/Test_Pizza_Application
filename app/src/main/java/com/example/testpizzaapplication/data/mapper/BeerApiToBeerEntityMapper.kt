package com.example.testpizzaapplication.data.mapper

import com.example.testpizzaapplication.data.service.api.BeerApi
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import javax.inject.Inject

class BeerApiToBeerEntityMapper @Inject constructor() : (BeerApi) -> BeerEntity {
    override fun invoke(beerApi: BeerApi): BeerEntity {
        return BeerEntity(
            id = beerApi.id,
            name = beerApi.name,
            description = beerApi.description,
            url = beerApi.url,
            fortress = beerApi.fortress.toString()
        )
    }
}