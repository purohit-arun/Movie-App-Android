package com.example.allinoneapppractise.didemo

import com.anushka.didemo.MainActivity
import com.anushka.didemo.SmartPhone
import dagger.Component

@Component(modules = [MemoryCardModule::class,NCBatteryModule::class])
interface SmartPhoneComponent {
    fun inject(mainActivity: MainActivity)
}