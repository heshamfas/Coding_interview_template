package com.heshamfas.nasa_earth.network

import com.heshamfas.nasa_earth.entities.NasaNatural
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EarthInfoNetworkCall {
    val TAG by lazy { EarthInfoNetworkCall::class.java.simpleName }

    private val restAPI = RestAPI.createService(IEarthInfoService::class.java)
    companion object{
        val naturalService = EarthInfoNetworkCall()
    }

    fun getEarthInfoListForToday(subscription: Scheduler = Schedulers.io(), observeScheduler: Scheduler = AndroidSchedulers.mainThread()): Single<NasaNatural> {
                return restAPI.getNasaNatural(/*date = getTodayDate()*/)
                    .subscribeOn(subscription)
                    .observeOn(observeScheduler)
    }
}