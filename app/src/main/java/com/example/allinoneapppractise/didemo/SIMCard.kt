package com.anushka.didemo

import android.util.Log
import javax.inject.Inject


class SIMCard @Inject constructor(private val serviceProvider: ServiceProvider) {
    //field injection
    //lateinit var serviceProvider:ServiceProvider

    init {
        Log.i("MYTAG", "SIM Card Constructed")
    }

    //method injection
    /*
      private lateinit var serviceProvider: ServiceProvider
    private fun setServiceProvider(serviceProvider: ServiceProvider){
        this.serviceProvider = serviceProvider
    }*/

    fun getConnection() {
        serviceProvider.getServiceProvider()
    }
}