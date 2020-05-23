package com.heshamfas.ny_data.model

import com.heshamfas.ny_data.entities.NYEdu
import com.heshamfas.ny_data.entities.SAT
import com.heshamfas.ny_data.network.SchoolNetworkCall
import io.reactivex.Single

class SchoolModel {
    val TAG by lazy { this::class.java.simpleName }

    companion object{
        val shared = SchoolModel()
    }

    fun getSATForSchool(city: String): Single<SAT>{
            return SchoolNetworkCall.SchoolService.getSATForSchool(city)
    }

    fun getSchoolList():Single<NYEdu> {
            return SchoolNetworkCall.SchoolService.getSchoolList()
    }
}