package com.heshamfas.lcodingex.network

import com.heshamfas.lcodingex.BuildConfig
import com.heshamfas.lcodingex.entities.CityData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherNetworkCall {
    val TAG by lazy { WeatherNetworkCall::class.java.simpleName }

    private val restAPI = RestAPI.createService(IWeatherService::class.java)
    companion object{
        val weatherService = WeatherNetworkCall()
    }
    fun getWeatherForCity(city: String, apiKey:String = BuildConfig.KEY): Single<CityData> {
        return restAPI.getWeatherForCity(city, apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}