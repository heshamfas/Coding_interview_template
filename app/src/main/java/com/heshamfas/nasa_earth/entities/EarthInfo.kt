package com.heshamfas.nasa_earth.entities

data class EarthInfo(
    val attitude_quaternions: AttitudeQuaternions = AttitudeQuaternions(),
    val caption: String = "",
    val centroid_coordinates: CentroidCoordinates = CentroidCoordinates(),
    val coords: Coords = Coords(),
    val date: String = "",
    val dscovr_j2000_position: DscovrJ2000Position = DscovrJ2000Position(),
    val identifier: String = "",
    val image: String = "",
    val lunar_j2000_position: LunarJ2000Position = LunarJ2000Position(),
    val sun_j2000_position: SunJ2000Position = SunJ2000Position(),
    val version: String = ""
)