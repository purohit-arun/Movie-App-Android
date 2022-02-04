package com.example.allinoneapppractise.bound_service_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityBoundServiceDemoBinding

class BoundServiceDemo : AppCompatActivity() {
    private lateinit var binding: ActivityBoundServiceDemoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bound_service_demo)

    }
}