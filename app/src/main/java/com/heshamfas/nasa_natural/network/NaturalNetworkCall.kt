package com.heshamfas.nasa_natural.network

import com.heshamfas.nasa_natural.entities.NasaNatural
import com.heshamfas.nasa_natural.Utils.getTodayDate
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NaturalNetworkCall {
    val TAG by lazy { NaturalNetworkCall::class.java.simpleName }

    private val restAPI = RestAPI.createService(INaturalService::class.java)
    companion object{
        val naturalService = NaturalNetworkCall()
    }

    fun getEarthInfoListForToday(subscription: Scheduler = Schedulers.io(), observeScheduler: Scheduler = AndroidSchedulers.mainThread()): Single<NasaNatural> {
                return restAPI.getNasaNatural(date = getTodayDate())
                    .subscribeOn(subscription)
                    .observeOn(observeScheduler)
    }
}