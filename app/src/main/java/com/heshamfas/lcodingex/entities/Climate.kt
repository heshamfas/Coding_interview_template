package com.heshamfas.lcodingex.entities

data class Climate(
    val clouds: Clouds = Clouds(),
    val dt: Int = 0,
    val dt_txt: String = "",
    val main: Main = Main(),
    val rain: Rain = Rain(),
    val sys: Sys = Sys(),
    val weather: List<Weather> = listOf(),
    val wind: Wind = Wind()
)