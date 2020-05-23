package com.heshamfas.ny_data.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heshamfas.ny_data.entities.NYEdu
import com.heshamfas.ny_data.entities.SAT
import com.heshamfas.ny_data.model.SchoolModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class SATViewModel constructor(): ViewModel() {
    constructor(dbn: String) : this() {
        this.dbn = dbn
    }
    lateinit var dbn : String
    private val TAG by lazy { this::class.java.simpleName }
    val model = SchoolModel.shared
    private val disposables = CompositeDisposable()
    val satInfo: MutableLiveData<SAT> by lazy {
        MutableLiveData<SAT>() . also { getSATINfo(dbn)}
    }

    val responseError = MutableLiveData<Throwable>()

    private fun getSATINfo(dbn:String){
        model.getSATForSchool(dbn)
            .subscribeBy(
                onSuccess = {
                    satData ->
                    satInfo.postValue(satData)
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



