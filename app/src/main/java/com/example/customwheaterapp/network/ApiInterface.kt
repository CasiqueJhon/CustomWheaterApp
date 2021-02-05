package com.example.customwheaterapp.network

import com.example.customwheaterapp.models.WeatherResponse
import com.example.customwheaterapp.models.WeatherResponseForecast
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


        @GET("weather")
        suspend fun getWeatherByLocation(
                @Query("lat")
                latitude: String,
                @Query("lon")
                longitude: String
        ): Response<WeatherResponse>

        @GET("weather")
        suspend fun getWeatherByCityID(
                @Query("id")
                query: String
        ): Response<WeatherResponse>

        @GET("onecall")
        suspend fun getWeatherForecast(
                @Query("lat")
                latitude: String,
                @Query("lon")
                longitude: String,
                @Query("exclude")
                exclude: String
        ): Response<WeatherResponseForecast>
}