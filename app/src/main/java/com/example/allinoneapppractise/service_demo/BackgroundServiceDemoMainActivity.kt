package com.example.allinoneapppractise.service_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.allinoneapppractise.R

class BackgroundServiceDemoMainActivity : AppCompatActivity() {
    private lateinit var btnForeground: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background_serivce_demo_main)

        btnForeground = findViewById(R.id.background_service_btn)

        btnForeground.setOnClickListener {
            val intent = Intent(this, TimerForegroundService::class.java)
            ContextCompat.startForegroundService(this, intent)

        }

    }
}