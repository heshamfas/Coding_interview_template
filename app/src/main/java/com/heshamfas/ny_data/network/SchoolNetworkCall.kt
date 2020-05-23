package com.heshamfas.ny_data.network

import com.heshamfas.ny_data.BuildConfig
import com.heshamfas.ny_data.entities.NYEdu
import com.heshamfas.ny_data.entities.SAT
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchoolNetworkCall {
    val TAG by lazy { SchoolNetworkCall::class.java.simpleName }

    private val restAPI = RestAPI.createService(ISchoolService::class.java)
    companion object{
        val SchoolService = SchoolNetworkCall()
    }
    fun getSATForSchool(dbn: String/*, apiKey:String = BuildConfig.KEY*/): Single<SAT> {
        return restAPI.getSATForSchool(dbn = dbn)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getSchoolList(): Single<NYEdu> {
                return restAPI.getSchoolsList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
    }
}