package com.example.customwheaterapp.network

import com.example.customwheaterapp.BuildConfig
import com.example.customwheaterapp.utils.Constant.Companion.BASE_URL
import com.ihsanbal.logging.LoggingInterceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.logging.Level

class RetrofitClient {

    companion object {

        private val retrofit by lazy {
            val httpClient = OkHttpClient.Builder().addInterceptor(QueryParameterAddInterceptor()).apply {
                addInterceptor(
                        LoggingInterceptor.Builder()
                                .setLevel(com.ihsanbal.logging.Level.BASIC)
                                .log(Platform.INFO)
                                .request("LOG")
                                .response("LOG")
                                .build()
                )
            }.build()

            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(httpClient)
                    .build()
        }

        val api by lazy {
            retrofit.create(ApiInterface::class.java)
        }
    }
}

