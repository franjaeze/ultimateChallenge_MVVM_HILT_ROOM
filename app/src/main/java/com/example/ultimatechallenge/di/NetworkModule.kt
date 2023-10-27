package com.example.ultimatechallenge.di

import com.example.ultimatechallenge.core.Config
import com.example.ultimatechallenge.core.InterceptorCustom
import com.example.ultimatechallenge.data.network.AirportApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    var client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor).addInterceptor(InterceptorCustom)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val apiKey = Config.apiKey
        val baseUrl = Config.baseUrl

        client.newBuilder().addNetworkInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Api-Key", apiKey)
                .build()
            chain.proceed(request)
        })

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):AirportApiClient{
        return retrofit.create(AirportApiClient::class.java)
    }
}