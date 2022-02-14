package com.example.allinoneapppractise.didemo

import com.anushka.didemo.SmartPhone
import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone():SmartPhone
}