package com.heshamfas.nasa_earth.utils

import android.net.Uri
import com.heshamfas.nasa_earth.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

object Utils  {

    fun getTodayDate():String{
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
    fun getFormattedImageURL(date: String, imageName:String):Uri{
        var dateString = if(date.contains(" ")){
            date.subSequence(0, date.indexOf(" ")).toString().trim()
        }else{
            date
        }
        val imageDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateString)
        val dateFormatted = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(imageDate)
        return Uri.parse("${BuildConfig.URL}archive/enhanced/$dateFormatted/png/$imageName.png")
    }

}