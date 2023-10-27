package com.example.ultimatechallenge.data.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ultimatechallenge.domain.model.Airport

@Entity(tableName = "airport_table")
data class AirportEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "icao") val icao: String,
    @ColumnInfo(name = "iata")val iata: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "city")val city: String,
    @ColumnInfo(name = "region")val region: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "elevation_ft") val elevationFt: Int,
    @ColumnInfo(name = "latitude")val latitude: String,
    @ColumnInfo(name = "longitude")val longitude: String,
    @ColumnInfo(name = "timezone")val timezone: String
)


fun Airport.toDatabase() = AirportEntity(
    icao = icao,
    iata= iata,
    name= name ,
    city=city ,
    region=region,
    country=country,
    elevationFt = elevationFt,
    latitude = latitude,
    longitude = longitude,
    timezone = timezone

)