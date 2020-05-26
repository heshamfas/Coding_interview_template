package com.heshamfas.nasa_earth.model

import com.heshamfas.nasa_earth.entities.NasaNatural
import com.heshamfas.nasa_earth.network.EarthInfoNetworkCall
import io.reactivex.Observable
import io.reactivex.Single

class PlanetModel {
    val TAG by lazy { this::class.java.simpleName }

    companion object{
        val shared = PlanetModel()
    }

    fun getEarthInfoList():Single<NasaNatural> {
            return EarthInfoNetworkCall.naturalService.getEarthInfoListForToday()
    }
}