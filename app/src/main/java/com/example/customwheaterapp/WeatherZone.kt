package com.example.customwheaterapp

import android.app.Application
import android.content.Context

class WeatherZone: Application() {
    companion object{
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context =applicationContext
    }
}