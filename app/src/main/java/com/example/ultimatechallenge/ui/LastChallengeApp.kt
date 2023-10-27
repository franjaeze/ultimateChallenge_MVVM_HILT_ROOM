package com.example.ultimatechallenge.ui

import android.app.Application
import com.example.ultimatechallenge.core.Config
import com.example.ultimatechallenge.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LastChallengeApp: Application(){
    override fun onCreate() {
        super.onCreate()

        Config.apiKey = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.quotes_api_base_url)
    }
}