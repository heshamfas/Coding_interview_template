package com.heshamfas.nasa_earth.network

import com.heshamfas.nasa_earth.BuildConfig
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestAPI {

    val TAG by lazy { this::class.java.simpleName }
    private val API_BASE_URL = BuildConfig.URL
    var retrofit: Retrofit? = null
    private val retrofitBuilder = Retrofit.Builder()
    .baseUrl(API_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    private val okHttpClientBuilder = OkHttpClient.Builder()
    var okHttpClient: OkHttpClient

    init {
        val okHttpDispatcher = Dispatcher()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClientBuilder
            .dispatcher(okHttpDispatcher)
            .addNetworkInterceptor(interceptor)
        okHttpClient = okHttpClientBuilder.build()
        if (retrofit == null) {
            retrofit = retrofitBuilder.client(okHttpClient).build()
        }
    }

    fun <S> createService(serviceClass: Class<S>): S {
        return retrofit?.create(serviceClass)!!
    }
}