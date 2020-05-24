package com.heshamfas.nasa_natural.model

import com.heshamfas.nasa_natural.entities.NasaNatural
import com.heshamfas.nasa_natural.network.NaturalNetworkCall
import io.reactivex.Single

class PlanetModel {
    val TAG by lazy { this::class.java.simpleName }

    companion object{
        val shared = PlanetModel()
    }

    fun getEarthInfoList():Single<NasaNatural> {
            return NaturalNetworkCall.naturalService.getEarthInfoListForToday()
    }
}