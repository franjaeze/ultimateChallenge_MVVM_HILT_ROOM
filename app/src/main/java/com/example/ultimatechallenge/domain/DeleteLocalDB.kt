package com.example.ultimatechallenge.domain

import android.util.Log
import com.example.ultimatechallenge.data.AirportRepository
import com.example.ultimatechallenge.data.database.Entities.toDatabase
import com.example.ultimatechallenge.domain.model.Airport
import javax.inject.Inject

class DeleteLocalDB @Inject constructor(private val repository: AirportRepository) {
    suspend operator fun invoke(){
       repository.clearAirports()

    }

}