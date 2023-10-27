package com.example.ultimatechallenge.data.network

import com.example.ultimatechallenge.data.model.AirportModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AirportService @Inject constructor(private val service: AirportApiClient) {

    suspend fun getArgAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getArgAirports()
            response.body() ?: emptyList()
        }
    }

    suspend fun getItAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getItAirports()
            response.body() ?: emptyList()
        }
    }
    suspend fun getFrAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getFrAirports()
            response.body() ?: emptyList()
        }
    }
    suspend fun getGbAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getGbAirports()
            response.body() ?: emptyList()
        }
    }
    suspend fun getUsAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getUsAirports()
            response.body() ?: emptyList()
        }
    }
    suspend fun getMxAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getMxAirports()
            response.body() ?: emptyList()
        }
    }
    suspend fun getBrAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getBrAirports()
            response.body() ?: emptyList()
        }
    }

    suspend fun getEsAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getEsAirports()
            response.body() ?: emptyList()
        }
    }

    suspend fun getAuAirports(): List<AirportModel> {
        return withContext(Dispatchers.IO) {
            val response = service.getAuAirports()
            response.body() ?: emptyList()
        }
    }
}