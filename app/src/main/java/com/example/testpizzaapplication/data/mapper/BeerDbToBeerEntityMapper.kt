package com.example.testpizzaapplication.data.mapper

import com.example.testpizzaapplication.data.db.entity.BeerDb
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import javax.inject.Inject

class BeerDbToBeerEntityMapper @Inject constructor() : (BeerDb) -> BeerEntity {
    override fun invoke(beerDb: BeerDb): BeerEntity {
        return BeerEntity(
            id = beerDb.id,
            name = beerDb.name,
            description = beerDb.description,
            url = beerDb.url,
            fortress = beerDb.fortress.toString()
        )
    }
}
