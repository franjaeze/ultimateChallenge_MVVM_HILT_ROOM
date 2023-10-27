package com.example.ultimatechallenge.di

import android.content.Context
import androidx.room.Room
import com.example.ultimatechallenge.data.database.AirportDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val AIRPORT_DATABASE_NAME = "airport_database"
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context:Context)
    = Room.databaseBuilder(context,AirportDatabase::class.java,AIRPORT_DATABASE_NAME)
        .build()

    @Singleton
    @Provides
    fun provideAirportDao(db:AirportDatabase) = db.getAirportDao()
}