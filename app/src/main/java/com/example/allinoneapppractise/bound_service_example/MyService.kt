package com.example.allinoneapppractise.bound_service_example

import android.app.Service
import android.content.Intent
import android.nfc.cardemulation.HostNfcFService
import android.os.Binder
import android.os.Handler
import android.os.IBinder
import android.util.Log

class MyService(
    var mMaxValue: Int = 0,
    var mProgress: Int = 0,
    var mIsPaused: Boolean = false
) :
    Service(), Runnable {
    private val TAG = "MyService"
    private val mBinder: IBinder = MyBinder()
    private lateinit var mHandler: Handler


    override fun onCreate() {
        mHandler = Handler()
        mProgress = 0
        mIsPaused = true
        mMaxValue = 5000


        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder {
        return mBinder
    }

    class MyBinder() : Binder() {
        companion object {
            fun getService(): MyService {
                return MyService()
            }
        }
    }


    private fun startPretendLongRunningTask() {
        val runnable = Runnable {
            if (mProgress > mMaxValue || mIsPaused) {
                Log.i(TAG, "startPretendLongRunningTask: removing callbacks")
                mHandler.removeCallbacks(this)
                pausePretendLongRunningTask()
            } else {
                Log.i(TAG, "Update the progress $mProgress")
                mProgress += 100
                mHandler.postDelayed(this, 100)
            }
        }
        mHandler.postDelayed(runnable, 100)
    }

    private fun pausePretendLongRunningTask() {
        mIsPaused = true
    }

    private fun unPausedPretendLongRunningTask() {
        mIsPaused = true
        startPretendLongRunningTask()
    }

    fun resetTask() {
        mProgress = 0
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        super.onTaskRemoved(rootIntent)
        stopSelf()
    }


    override fun run() {
    }
}

