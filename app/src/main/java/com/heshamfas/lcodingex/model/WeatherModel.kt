package com.heshamfas.lcodingex.model

import com.heshamfas.lcodingex.entities.CityData
import com.heshamfas.lcodingex.network.WeatherNetworkCall
import io.reactivex.Single

class WeatherModel {
    val TAG by lazy { this::class.java.simpleName }

    companion object{
        val shared = WeatherModel()
    }

    fun getWeatherForCity(city: String): Single<CityData>{
            return WeatherNetworkCall.weatherService.getWeatherForCity(city)
    }
}