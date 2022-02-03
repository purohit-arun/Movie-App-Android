package com.example.allinoneapppractise.mediaplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityServiceMediaPlayerBinding

class ServiceMediaPlayer : AppCompatActivity() {
    private lateinit var binding: ActivityServiceMediaPlayerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_service_media_player)
        val intent = Intent(this, MusicService::class.java)
        binding.playBtn.setOnClickListener {
            startService(intent)
        }
        binding.pauseBtn2.setOnClickListener{
            stopService(intent)
        }
    }
}