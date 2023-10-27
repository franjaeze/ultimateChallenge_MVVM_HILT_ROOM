package com.example.ultimatechallenge.domain

import android.util.Log
import com.example.ultimatechallenge.data.AirportRepository
import com.example.ultimatechallenge.data.database.Entities.toDatabase
import com.example.ultimatechallenge.domain.model.Airport
import javax.inject.Inject

class GetFrAirportsUseCase  @Inject constructor(private val repository: AirportRepository) {
    suspend operator fun invoke():List<Airport>{
        val dbAirports =  repository.getFrAirportsFromDatabase()
        if(!dbAirports.isNullOrEmpty()){
            Log.d("Base de datos","Estoy trayendo los Airports de la BD")
            return dbAirports
        }else {
            val airports = repository.getFrAirportFromApi()
            return if(airports.isNotEmpty()){
                // Elimino los registros para hacer una nueva inserción
                //repository.clearAirports()

                //Inserto los nuevos registros
                repository.insertAirports(airports.map { it.toDatabase() })
                Log.d("Base de datos","Los traigo de la A.P.I. y luego los guardo en la BD")
                airports
            }else{
                repository.getAllArgAirportsFromDatabase()
            }
        }
    }

}