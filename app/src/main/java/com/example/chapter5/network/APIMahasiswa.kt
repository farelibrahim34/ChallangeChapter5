package com.example.chapter5.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIMahasiswa {
    const val BASE_URL = "https://6331b56ccff0e7bf70f4c553.mockapi.io/"

    val instance :APIInterface by lazy {
        val retrofit =Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(APIInterface::class.java)
    }




}