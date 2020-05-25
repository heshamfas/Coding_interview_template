package com.heshamfas.nasa_earth.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heshamfas.nasa_earth.entities.NasaNatural
import com.heshamfas.nasa_earth.model.PlanetModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel : ViewModel() {

    private val TAG by lazy { this::class.java.simpleName }
    val model = PlanetModel.shared
    private val disposables = CompositeDisposable()

     val nasaNatural: MutableLiveData<NasaNatural> by lazy {
         MutableLiveData<NasaNatural>() . also { getEarthInfoList()
         }
     }

    val responseError = MutableLiveData<Throwable>()

     private fun getEarthInfoList(){
     model.getEarthInfoList()
         .subscribeBy(
             onSuccess = {
                 nasaNatural.postValue(it)
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



