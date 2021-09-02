package com.example.testpizzaapplication.di.module

import android.content.Context
import androidx.room.Room
import com.example.testpizzaapplication.data.db.BeerDatabase
import com.example.testpizzaapplication.data.db.dao.BeersDao
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun providesRoomDatabase(context: Context): BeerDatabase {
        return Room.databaseBuilder(
            context,
            BeerDatabase::class.java,
            "beers.db"
        ).build()
    }

    @Provides
    fun providesBeersDao(beerDatabase: BeerDatabase): BeersDao {
        return beerDatabase.getBeersDao()
    }
}