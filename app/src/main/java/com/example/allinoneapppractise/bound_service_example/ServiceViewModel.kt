package com.example.allinoneapppractise.bound_service_example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.allinoneapppractise.bound_service_example.MyService.MyBinder
import android.content.ServiceConnection
import android.content.ComponentName
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LiveData

class ServiceViewModel : ViewModel() {
    private val mIsProgressUdpating = MutableLiveData<Boolean>()
    private val mBinder = MutableLiveData<MyBinder?>()
    val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            Log.d(TAG, "onServiceConnected: Connected to service")
            val binder = service as MyBinder
            mBinder.postValue(binder)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mBinder.postValue(null)
        }
    }
    val isProgressUpdating: LiveData<Boolean>
        get() = mIsProgressUdpating
    val binder: LiveData<MyBinder?>
        get() = mBinder

    companion object {
        private const val TAG = "ServiceViewModel"
    }
}