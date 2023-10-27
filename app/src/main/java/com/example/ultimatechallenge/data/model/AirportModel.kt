package com.example.ultimatechallenge.data.model

import com.google.gson.annotations.SerializedName

data class AirportModel(
@SerializedName("icao") val icao: String,
@SerializedName("iata")val iata: String,
@SerializedName("name")val name: String,
@SerializedName("city")val city: String,
@SerializedName("region")val region: String,
@SerializedName("country") val country: String,
@SerializedName("elevation_ft") val elevationFt: Int,
@SerializedName("latitude")val latitude: String,
@SerializedName("longitude")val longitude: String,
@SerializedName("timezone")val timezone: String
)