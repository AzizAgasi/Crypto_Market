package com.techdot.cryptomarket.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.moshi.MoshiConverterFactory
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.ArrayList

private const val BASE_URL = "https://www.cryptingup.com/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface CryptoApiService {
    @GET("markets")
    suspend fun getCryptoData(): CryptoMarket
}

object CryptoApi {
    val retrofitService: CryptoApiService by lazy {
        retrofit.create(CryptoApiService::class.java)
    }
}