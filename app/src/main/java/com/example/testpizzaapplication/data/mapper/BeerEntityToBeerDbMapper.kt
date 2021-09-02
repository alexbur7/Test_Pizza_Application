package com.example.testpizzaapplication.data.mapper

import com.example.testpizzaapplication.data.db.entity.BeerDb
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import javax.inject.Inject

class BeerEntityToBeerDbMapper @Inject constructor() : (BeerEntity) -> BeerDb {
    override fun invoke(beerEntity: BeerEntity): BeerDb {
        return BeerDb(
            id = beerEntity.id,
            name = beerEntity.name,
            description = beerEntity.description,
            url = beerEntity.url,
            fortress = beerEntity.fortress.toFloat()
        )
    }
}