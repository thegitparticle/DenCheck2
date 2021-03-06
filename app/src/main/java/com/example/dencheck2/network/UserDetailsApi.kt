package com.example.dencheck2.network

import retrofit2.Retrofit
import retrofit2.http.GET
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://apisayepirates.life/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL)
        .build()


interface UserDetailsApiInterface {
    @GET("users/my_clubs/82/")
    suspend fun getUserDetails(): List<ClansItem>
}


object UserDetailsApi {
    val retrofitService: UserDetailsApiInterface by lazy {
        retrofit.create(UserDetailsApiInterface::class.java)
    }
}
