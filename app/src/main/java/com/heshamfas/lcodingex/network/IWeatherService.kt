package com.heshamfas.lcodingex.network

import com.heshamfas.lcodingex.BuildConfig
import com.heshamfas.lcodingex.entities.CityData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherService {
    @GET("/data/2.5/forecast")
    fun getWeatherForCity(@Query("q") city: String,
                          @Query("appid") appId:String =  BuildConfig.KEY,
                          @Query("units") units:String="IMPERIAL"): Single<CityData>
}