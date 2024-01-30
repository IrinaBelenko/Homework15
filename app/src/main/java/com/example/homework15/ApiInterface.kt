package com.example.homework15

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("/v1/forecast?latitude=52.52&longitude=13.41")
    fun getMeteo(): Single<MeteoResponse>
}

data class MeteoResponse(
    val latitude: Long,
    val longitude: Long,
    @SerializedName("generationtime_ms")
    val generationtimems: Long,
    @SerializedName("utc_offset_seconds")
    val utcOffsetSeconds: Int,
    val timezone: String,
    @SerializedName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    val elevation: Long
)