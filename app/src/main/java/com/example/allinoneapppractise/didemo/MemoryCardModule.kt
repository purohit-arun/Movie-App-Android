package com.example.allinoneapppractise.didemo

import android.util.Log
import com.anushka.didemo.MemoryCard
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(val memorySize:Int) {
    @Provides
    fun provideMemoryCard(): MemoryCard {
        Log.i("MYTAG","Size of the memory is $memorySize")
        return MemoryCard()
    }
}