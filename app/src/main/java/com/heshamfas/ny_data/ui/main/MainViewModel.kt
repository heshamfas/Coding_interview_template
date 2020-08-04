package com.heshamfas.ny_data.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.heshamfas.ny_data.entities.NYEdu
import com.heshamfas.ny_data.model.SchoolModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel : ViewModel() {
    lateinit var dbn : String

    private val TAG by lazy { this::class.java.simpleName }
    val model = SchoolModel.shared
    private val disposables = CompositeDisposable()

     val nyEdu: MutableLiveData<NYEdu> by lazy {
         MutableLiveData<NYEdu>() . also { getSchoolList()}
     }

    val responseError = MutableLiveData<Throwable>()

     private fun getSchoolList(){
     model.getSchoolList()
         .subscribeBy(
             onSuccess = {
                 nyEdu.postValue(it)
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



