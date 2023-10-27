package com.example.ultimatechallenge.data.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ultimatechallenge.data.database.Entities.AirportEntity

@Dao
interface AirportDao {

    @Query("SELECT * FROM airport_table")
    suspend fun getAllAirports():List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'AR'")
    suspend fun getArgAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'FR'")
    suspend fun getFrAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'GB'")
    suspend fun getGbAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'BR'")
    suspend fun getBrAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'ES'")
    suspend fun getEsAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'MX'")
    suspend fun getMxAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'US'")
    suspend fun getUsAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'IT'")
    suspend fun getItAirports(): List<AirportEntity>

    @Query("SELECT * FROM airport_table WHERE country == 'AU'")
    suspend fun getAuAirports(): List<AirportEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(airports: List<AirportEntity>)

    @Query("DELETE FROM airport_table")
    suspend fun deleteAllAirports()

}