package com.example.testpizzaapplication.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testpizzaapplication.data.db.dao.BeersDao
import com.example.testpizzaapplication.data.db.entity.BeerDb

@Database(entities = [BeerDb::class], version = 1, exportSchema = false)
abstract class BeerDatabase : RoomDatabase() {

    abstract fun getBeersDao(): BeersDao
}
