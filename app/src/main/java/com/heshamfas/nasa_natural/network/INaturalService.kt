package com.heshamfas.nasa_natural.network

import com.heshamfas.nasa_natural.entities.NasaNatural
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface INaturalService {

    @GET("api/enhanced/date{date}/")
    fun getNasaNatural(@HeaderMap  headers:Map<String, String> = mapOf("Accept" to "application/json")
    , @Path("date") date:String): Single<NasaNatural>
}