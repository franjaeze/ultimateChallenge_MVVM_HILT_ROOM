package com.example.ultimatechallenge.data.network


import com.example.ultimatechallenge.data.model.AirportModel
import retrofit2.Response
import retrofit2.http.GET

interface AirportApiClient {
    @GET("/v1/airports?country=ar")
    suspend fun getArgAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=it")
    suspend fun getItAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=fr")
    suspend fun getFrAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=us")
    suspend fun getUsAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=br")
    suspend fun getBrAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=mx")
    suspend fun getMxAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=es")
    suspend fun getEsAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=gb")
    suspend fun getGbAirports(): Response<List<AirportModel>>

    @GET("/v1/airports?country=au")
    suspend fun getAuAirports(): Response<List<AirportModel>>
}