package com.example.ultimatechallenge.domain

import com.example.ultimatechallenge.data.AirportRepository
import com.example.ultimatechallenge.domain.model.Airport
import javax.inject.Inject

class GetRamdomAirportsUseCase @Inject constructor(private val repository: AirportRepository) {

    suspend operator fun invoke(): Airport? {
        val airports = repository.getAllArgAirportsFromDatabase()
        if (!airports.isNullOrEmpty()) {
            val randomNumber = (airports.indices).random()
            return airports[randomNumber]
        }
        return null
    }
}