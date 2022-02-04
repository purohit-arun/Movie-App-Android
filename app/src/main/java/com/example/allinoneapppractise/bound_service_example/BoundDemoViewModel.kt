package com.example.allinoneapppractise.bound_service_example

import android.content.ServiceConnection
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BoundDemoViewModel() : ViewModel() {
    private val TAG = "BoundDemoViewModel"

    private val mIsProgressUpdating = MutableLiveData<Boolean>()
    private val mBinder = MutableLiveData<MyService.MyBinder>()

//    private val serviceConnection = ServiceConnection{
//
//    }

}