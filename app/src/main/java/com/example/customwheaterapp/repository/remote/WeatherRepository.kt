package com.example.customwheaterapp.repository.remote

import com.example.customwheaterapp.network.RetrofitClient

class WeatherRepository {

    suspend fun getWeatherByLocation(lat:String, lon:String) = RetrofitClient.api.getWeatherByLocation(lat, lon)
    suspend fun getWeatherByCity(id:String) = RetrofitClient.api.getWeatherByCityID(id)
    suspend fun getWeatherForecast(lat: String, lon: String, exclude:String) = RetrofitClient.api.getWeatherForecast(lat, lat, exclude)
}