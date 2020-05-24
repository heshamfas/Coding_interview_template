package com.heshamfas.nasa_natural

import java.text.SimpleDateFormat
import java.util.*

object Utils  {

    fun getTodayDate():String{
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
    fun getFormattedImageURL(date: String, imageName:String):String{
        var url = ""
        val date = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).parse(date)?.toString()
        return "${BuildConfig.URL}archive/natural/$date/png/$imageName.png"//Uri.parse("$")
    }
}