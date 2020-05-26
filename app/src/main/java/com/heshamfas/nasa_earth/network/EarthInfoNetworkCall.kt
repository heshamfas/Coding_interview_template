package com.heshamfas.nasa_earth.network

import com.heshamfas.nasa_earth.entities.NasaNatural
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class EarthInfoNetworkCall {
    val TAG by lazy { EarthInfoNetworkCall::class.java.simpleName }

    private val restAPI = RestAPI.createService(IEarthInfoService::class.java)
    companion object{
        val naturalService = EarthInfoNetworkCall()
    }

    fun getEarthInfoListForToday(subscription: Scheduler = Schedulers.io(), observeScheduler: Scheduler = AndroidSchedulers.mainThread()): Single<NasaNatural> {
                return restAPI.getNasaNatural()
                    .subscribeOn(subscription)
                    .observeOn(observeScheduler)
    }
}