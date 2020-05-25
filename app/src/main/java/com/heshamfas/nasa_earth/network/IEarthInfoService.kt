package com.heshamfas.nasa_earth.network

import com.heshamfas.nasa_earth.entities.NasaNatural
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface IEarthInfoService {

    @GET("/api/enhanced/")
    fun getNasaNatural(@HeaderMap  headers:Map<String, String> = mapOf("Accept" to "application/json")
    ,@Query("api_key") apiKey :String = "DEMO_KEY"): Single<NasaNatural>

}