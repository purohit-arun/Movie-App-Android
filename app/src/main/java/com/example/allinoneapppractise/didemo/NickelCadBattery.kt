package com.example.allinoneapppractise.didemo

import android.util.Log
import com.anushka.didemo.Battery
import com.anushka.didemo.MemoryCard
import javax.inject.Inject

class NickelCadBattery @Inject constructor(val memoryCard: MemoryCard) : Battery {
    override fun getPower() {
        Log.i("MYTAG", "power from nickel cadmium ")
    }
}