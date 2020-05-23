package com.heshamfas.ny_data.network

import com.heshamfas.ny_data.BuildConfig
import com.heshamfas.ny_data.entities.NYEdu
import com.heshamfas.ny_data.entities.SAT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface ISchoolService {
    @GET("f9bf-2cp4")
    fun getSATForSchool(@HeaderMap  headers:Map<String, String> = mapOf("Accept" to "application/json")
        ,@Query("dbn") dbn: String
    ): Single<SAT>

    @GET("s3k6-pzi2")
    fun getSchoolsList(@HeaderMap  headers:Map<String, String> = mapOf("Accept" to "application/json" )
    ,@Query ("\$select") selection:String = "dbn,school_name"
    ): Single<NYEdu>
}