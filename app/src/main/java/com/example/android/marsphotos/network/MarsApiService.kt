package com.example.android.marsphotos.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

private val moshi = Moshi.Builder()

interface MarsApiService{

    @GET("photos")
    suspend fun getPhotos() : String
}

object MarsApi{
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}