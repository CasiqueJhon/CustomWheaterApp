package com.example.customwheaterapp.repository.local

import com.example.customwheaterapp.db.CityDatabase
import com.example.customwheaterapp.models.Cities
import com.example.customwheaterapp.models.CityUpdate

class CityRepository (private val database: CityDatabase) {

    suspend fun searchCities(key:String) = database.getCityDao().searchCity(key)
    suspend fun updateSavedCities(obj:CityUpdate) = database.getCityDao().updateSavedCity(obj)
    fun getSavedCities(key:Int) = database.getCityDao().getSaveCity(key)
    suspend fun deleteSavedCities(cities:Cities) = database.getCityDao().deleteSavedCity(cities)

}