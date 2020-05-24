package com.heshamfas.nasa_natural.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//Overide ViewModelProvider.NewInstanceFactory to create the ViewModle (VM).
class VMFactory(private val dbn:String):ViewModelProvider.NewInstanceFactory(){
    //P.S study the difference with ViewModelProvider.AndroidViewModelFactory(application: Application)
    //override fun <T: ViewModel?> create(modelClass: Class<T>): T = SATViewModel(dbn) as T
}

