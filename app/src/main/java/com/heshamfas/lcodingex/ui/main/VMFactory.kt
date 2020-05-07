package com.heshamfas.lcodingex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//Overide ViewModelProvider.NewInstanceFactory to create the ViewModle (VM).
class VMFactory(private val cityName: String):ViewModelProvider.NewInstanceFactory(){
    //P.S study the difference with ViewModelProvider.AndroidViewModelFactory(application: Application)
    override fun <T: ViewModel?> create(modelClass: Class<T>): T = MainViewModel(cityName) as T
}

