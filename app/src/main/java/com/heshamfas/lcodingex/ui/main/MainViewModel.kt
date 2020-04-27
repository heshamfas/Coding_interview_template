package com.heshamfas.lcodingex.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heshamfas.lcodingex.entities.CityData
import com.heshamfas.lcodingex.model.WeatherModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel : ViewModel() {

    private val TAG by lazy { this::class.java.simpleName }
    val model = WeatherModel.shared
    private val disposables = CompositeDisposable()
    val weatherResponse = MutableLiveData<CityData>()
    val responseError = MutableLiveData<Throwable>()

    fun getCityDataByName(city:String){
        model.getWeatherForCity(city)
            .subscribeBy(
                onSuccess = {
                    cityData ->
                    weatherResponse.postValue(cityData)
                },
                onError = {
                    responseError.postValue(it)
                }
            )
            .addTo(disposables)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}
