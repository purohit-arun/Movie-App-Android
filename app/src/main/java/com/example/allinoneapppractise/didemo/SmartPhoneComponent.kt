package com.example.allinoneapppractise.didemo

import com.anushka.didemo.SmartPhone
import dagger.Component

@Component
interface SmartPhoneComponent {
    fun getSmartPhone():SmartPhone
}