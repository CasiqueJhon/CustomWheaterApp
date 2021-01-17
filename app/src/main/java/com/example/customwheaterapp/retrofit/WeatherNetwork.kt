package com.example.customwheaterapp.retrofit

import android.widget.TextView
import com.example.customwheaterapp.network.WeatherResponse
import com.example.customwheaterapp.network.WeatherService
import com.example.customwheaterapp.utils.Constant.Companion.AppId
import com.example.customwheaterapp.utils.Constant.Companion.BASE_URL
import com.example.customwheaterapp.utils.Constant.Companion.lat
import com.example.customwheaterapp.utils.Constant.Companion.lon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherNetwork {
    private var weatherData : TextView? = null

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(WeatherService.WeatherService::class.java)
    val call = service.getCurrentWeatherData(lat, lon, AppId)

    fun getWeatherResponse() {
        call.enqueue(object : Callback<WeatherResponse> {

            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.code() == 200){
                    val weatherResponse = response.body()!!
                    val stringBuilder = "Country: " +
                            weatherResponse.sys!!.country +
                            "\n" +
                            "Temperature: " +
                            weatherResponse.main!!.temp +
                            "\n" +
                            "Temperature(Min): " +
                            weatherResponse.main!!.temp_min +
                            "\n" +
                            "Temperature(Max): " +
                            weatherResponse.main!!.temp_max +
                            "\n" +
                            "Humidity: " +
                            weatherResponse.main!!.humidity +
                            "\n" +
                            "Pressure: " +
                            weatherResponse.main!!.pressure

                    weatherData?.text = stringBuilder
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                weatherData?.text = t.message
            }
        })
    }
}