package com.heshamfas.lcodingex.entities

import com.google.gson.annotations.SerializedName

data class CityData(
    val city: City = City(),
    val cnt: Int = 0,
    val cod: String = "",
    @SerializedName("list")
    val climates: List<Climate> = listOf(),
    val message: Int = 0
)