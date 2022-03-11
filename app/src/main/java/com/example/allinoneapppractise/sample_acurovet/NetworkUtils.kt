package com.example.allinoneapppractise.sample_acurovet

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object NetworkUtils : ConnectivityManager.NetworkCallback() {

    private var connectivityManager: ConnectivityManager? = null
    private val networkLiveData = MutableLiveData(false)

    fun initialize(context: Context) {
        connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager?.registerDefaultNetworkCallback(this)
        } else {
            val builder = NetworkRequest.Builder()
            connectivityManager?.registerNetworkCallback(builder.build(), this)
        }
    }

    fun isConnected(): Boolean {
        var isConnected = false
        connectivityManager?.allNetworks?.forEach { network ->
            connectivityManager?.getNetworkCapabilities(network)?.let {
                if (it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    isConnected = true
                    return@forEach
                }
            }
        } ?: throw Exception("NetworkUtils not Initialized")

        return isConnected
    }

    fun getNetworkLiveData(): LiveData<Boolean> {
        return networkLiveData.apply {
            postValue(isConnected())
        }
    }

    override fun onAvailable(network: Network) {
        networkLiveData.postValue(true)
    }

    override fun onLost(network: Network) {
        networkLiveData.postValue(false)
    }
}