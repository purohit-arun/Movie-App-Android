package com.example.allinoneapppractise.service_demo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.allinoneapppractise.R
import kotlinx.coroutines.delay
import java.util.*

class TimerForegroundService : Service() {

    private val TAG = "TimerForegroundService"
    private val timer = Timer()

    override fun onCreate() {
        super.onCreate()
        startTimer()
        Log.e(TAG, "onCreate: ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_NOT_STICKY
        showNotification()
    }

    private fun startTimer() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                startTimer()
                Log.e(TAG, "run: Timer called after 5 seconds")
            }
        }, 5000)
    }


    private fun showNotification() {
        val id = TAG
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
            val name: CharSequence = TAG
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(id, name, importance)
            channel.description = id
            val notificationManager = applicationContext.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, id)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Foreground Service")
            .setContentText("Timer is running")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        startForeground(1001, builder.build())
        Log.e(TAG, "showNotification: ")
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun bindService(service: Intent?, conn: ServiceConnection, flags: Int): Boolean {
        return super.bindService(service, conn, flags)
    }

    override fun stopService(name: Intent?): Boolean {
        return super.stopService(name)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }

}