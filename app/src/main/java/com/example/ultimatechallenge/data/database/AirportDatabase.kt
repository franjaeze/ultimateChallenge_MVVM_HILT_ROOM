package com.example.ultimatechallenge.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ultimatechallenge.data.database.Dao.AirportDao
import com.example.ultimatechallenge.data.database.Entities.AirportEntity

@Database (entities = [AirportEntity::class], version = 1)
abstract class AirportDatabase: RoomDatabase() {

    abstract fun getAirportDao():AirportDao
}