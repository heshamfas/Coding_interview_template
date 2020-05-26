package com.heshamfas.nasa_earth.utils

import android.net.Uri
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)

internal class UtilsTest {
    val imageName = "epic_RGB_20200514000831"
    val imageDate = "2020-05-14 03:20:04"
    lateinit var mockedUri:Uri
    val malfomedDate = "not a date"


    @Before
    fun before(){
        mockedUri = Uri.parse("https://epic.gsfc.nasa.gov/archive/enhanced/2020/05/14/png/epic_RGB_20200514000831.png")
    }

    @Test
    fun givenValidImageNameAndDateStringShouldReturnValidUrl(){
        assertEquals((mockedUri) ,Utils.getFormattedImageURL(imageDate,imageName))
    }

    @Test
    fun givenAnInvalidDateShouldReturnAnEmptyUri(){
        assertEquals(Uri.EMPTY ,Utils.getFormattedImageURL(malfomedDate,imageName))
    }

    @Test
    fun givenValidDateGetFormattedCaptionDateShouldReturnFormattedDate(){
        val consumerFormattedDate = "05/14/2020 03:20:04 AM"
        assertEquals(consumerFormattedDate, Utils.getFormattedCaptionDate(imageDate))
    }

    @Test
    fun  givenInvalidDateGetFormattedCaptionDateShouldReturnAnEmptyString(){
        assertEquals("", Utils.getFormattedCaptionDate(malfomedDate))
    }
}