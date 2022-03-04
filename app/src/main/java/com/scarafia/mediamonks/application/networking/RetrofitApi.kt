package com.scarafia.mediamonks.application.networking

import com.scarafia.mediamonks.application.ApplicationConstants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitApi {

    private val httpClient = OkHttpClient.Builder()
        .readTimeout(ApplicationConstants.API_TIME_OUT, TimeUnit.SECONDS)
        .writeTimeout(ApplicationConstants.API_TIME_OUT, TimeUnit.SECONDS)

    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .client(httpClient.build())
        .baseUrl(ApplicationConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}