package com.example.allinoneapppractise.didemo

import com.anushka.didemo.Battery
import dagger.Binds
import dagger.Module

@Module
abstract class NCBatteryModule {
    @Binds
    abstract fun bindsNCBattery(nickelCadBattery: NickelCadBattery): Battery
}