package com.example.ultimatechallenge.domain.model

import com.example.ultimatechallenge.data.database.Entities.AirportEntity
import com.example.ultimatechallenge.data.model.AirportModel


data class Airport(
    val icao: String,
    val iata: String,
    val name: String,
    val city: String,
    val region: String,
    val country: String,
    val elevationFt: Int,
    val latitude: String,
    val longitude: String,
    val timezone: String)

fun AirportModel.toDomain() = Airport(icao, iata, name,city, region, country, elevationFt,latitude, longitude, timezone)
fun AirportEntity.toDomain() = Airport(icao, iata, name,city, region, country, elevationFt,latitude, longitude, timezone)