package com.heshamfas.nasa_natural.entities

data class Coords(
    val attitude_quaternions: AttitudeQuaternions = AttitudeQuaternions(),
    val centroid_coordinates: CentroidCoordinates = CentroidCoordinates(),
    val dscovr_j2000_position: DscovrJ2000Position = DscovrJ2000Position(),
    val lunar_j2000_position: LunarJ2000Position = LunarJ2000Position(),
    val sun_j2000_position: SunJ2000Position = SunJ2000Position()
)