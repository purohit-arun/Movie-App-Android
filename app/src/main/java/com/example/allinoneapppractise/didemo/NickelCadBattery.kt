package com.example.allinoneapppractise.didemo

import android.util.Log
import com.anushka.didemo.Battery
import javax.inject.Inject

class NickelCadBattery @Inject constructor() : Battery {
    override fun getPower() {
        Log.i("MYTAG", "power from nickel cadmium ")
    }
}