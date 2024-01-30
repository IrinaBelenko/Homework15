package com.example.homework15

import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v1/forecast?latitude=52.52&longitude=13.41")
    fun getMeteo(): Single<MeteoResponse>
}

data class MeteoResponse(
    val latitude: Long,
    val longitude: Long,
    val timezone: String,
    val elevation: Long
)