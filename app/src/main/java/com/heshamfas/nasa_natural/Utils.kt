package com.heshamfas.nasa_natural

import android.net.Uri
import java.text.SimpleDateFormat
import java.util.*

object Utils  {

    fun getTodayDate():String{
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
    fun getFormattedImageURL(date: String, imageName:String):Uri{
        var dateString = if(date.contains(" ")){
            date.subSequence(0, date.indexOf(" ")).toString()
        }else{
            date
        }
        val imageDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateString)
        val dateFormatted = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(imageDate)
        return Uri.parse("${BuildConfig.URL}archive/enhanced/$dateFormatted/png/$imageName.png")
    }
}