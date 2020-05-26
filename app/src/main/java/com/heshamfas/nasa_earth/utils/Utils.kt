package com.heshamfas.nasa_earth.utils

import android.net.Uri
import com.heshamfas.nasa_earth.BuildConfig
import java.text.SimpleDateFormat
import java.util.*

object Utils  {
    private fun getDateWithoutTime(date:String): String{
        var dateString = if(date.contains(" ")){
            date.subSequence(0, date.indexOf(" ")).toString().trim()
        }else{
            date
        }
        return dateString
    }

    fun getFormattedImageURL(date: String, imageName:String):Uri{
        val dateString = getDateWithoutTime(date)
        try {
            val imageDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(dateString)
            val dateFormatted = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(imageDate!!)
            return dateFormatted.let { Uri.parse("${BuildConfig.URL}archive/enhanced/$dateFormatted/png/$imageName.png") }
        }catch (e:Throwable){
            return Uri.EMPTY
        }
    }


    fun getFormattedCaptionDate(imageDate:String):String{
        try {
            val date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault()).parse(imageDate)
            return SimpleDateFormat("MM/dd/yyyy hh:mm:ss a", Locale.getDefault()).format(date!!)
        }catch (ex:Throwable){
            return ""
        }

    }
}