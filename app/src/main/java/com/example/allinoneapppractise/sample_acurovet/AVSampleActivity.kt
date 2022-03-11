package com.example.allinoneapppractise.sample_acurovet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityAvsampleBinding
import com.google.android.material.textview.MaterialTextView

class AVSampleActivity : BaseActivity() {
    private lateinit var binding: ActivityAvsampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_avsample)
        setSupportActionBar(binding.topNavigation.toolbar)
    }

    override fun getView(): MaterialTextView {
        return binding.topNavigation.showConnectionStatus
    }
}