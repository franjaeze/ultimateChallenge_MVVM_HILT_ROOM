package com.example.ultimatechallenge.data

import com.example.ultimatechallenge.data.database.Dao.AirportDao
import com.example.ultimatechallenge.data.database.Entities.AirportEntity
import com.example.ultimatechallenge.data.model.AirportModel
import com.example.ultimatechallenge.domain.model.Airport
import com.example.ultimatechallenge.domain.model.toDomain
import com.example.ultimatechallenge.data.network.AirportService
import javax.inject.Inject

class AirportRepository @Inject constructor(
    private val service: AirportService,
    private val airportDao: AirportDao
) {
// argentina
    suspend fun getArgAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getArgAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getAllArgAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getArgAirports()
        return response.map { it.toDomain() }
    }

// italy
    suspend fun getItAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getItAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getItAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getItAirports()
        return response.map { it.toDomain() }
    }
    // france
    suspend fun getFrAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getFrAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getFrAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getFrAirports()
        return response.map { it.toDomain() }
    }

    // gb
    suspend fun getGbAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getGbAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getGbAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getGbAirports()
        return response.map { it.toDomain() }
    }

    // Us
    suspend fun getUsAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getUsAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getUsAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getUsAirports()
        return response.map { it.toDomain() }
    }

    // Mx
    suspend fun getMxAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getMxAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getMxAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getMxAirports()
        return response.map { it.toDomain() }
    }

    // Es
    suspend fun getEsAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getEsAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getEsAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getEsAirports()
        return response.map { it.toDomain() }
    }

    // Br
    suspend fun getBrAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getBrAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getBrAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getBrAirports()
        return response.map { it.toDomain() }
    }

    //Au
    suspend fun getAuAirportFromApi(): List<Airport> {
        val response: List<AirportModel> = service.getAuAirports()
        return response.map { it.toDomain()}
    }

    suspend fun getAuAirportsFromDatabase():List<Airport>{
        val response: List<AirportEntity> =airportDao.getAuAirports()
        return response.map { it.toDomain() }
    }


    suspend fun insertAirports(airports:List<AirportEntity>){
        airportDao.insertAll(airports)
    }

    suspend fun clearAirports(){
        airportDao.deleteAllAirports()
    }
}