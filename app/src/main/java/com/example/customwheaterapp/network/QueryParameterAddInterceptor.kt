package com.example.customwheaterapp.network

import com.example.customwheaterapp.WeatherZone
import com.example.customwheaterapp.utils.Constant.Companion.AppId
import com.example.customwheaterapp.utils.PrefManager
import okhttp3.Interceptor
import okhttp3.Response

class QueryParameterAddInterceptor: Interceptor {

    val context = WeatherZone.context
    private val prefManager = PrefManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        var url = chain.request().url.newBuilder()
            .addQueryParameter("appiId", AppId )
            .addQueryParameter("units", prefManager.tempUnit)
            .build()

        val request = chain.request().newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}