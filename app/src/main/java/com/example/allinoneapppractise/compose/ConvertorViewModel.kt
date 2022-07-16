package com.example.allinoneapppractise.compose

import androidx.lifecycle.ViewModel

class ConvertorViewModel : ViewModel() {

    fun getConversion() = listOf(
        Conversion(1, "Pounds to Kilogram", "lbs", "kg", 0.453592),
        Conversion(2, "Kilogram to Pounds", "kg", "lbs", 2.20462),
        Conversion(3, "Yards to Meters", "yd", "m", 0.9144),
        Conversion(4, "Meters to Yards", "m", "yd", 1.09361),
        Conversion(5, "Miles to Kilometers", "mi", "km", 1.60934),
        Conversion(6, "Kilometers to Miles", "km", "mi", 0.621371),
    )
}