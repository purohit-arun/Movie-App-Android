package com.example.allinoneapppractise.bound_service_example

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityBoundServiceDemoBinding

class BoundServiceDemo : AppCompatActivity() {

    private lateinit var binding: ActivityBoundServiceDemoBinding
    private lateinit var myService: MyService
    private lateinit var mViewModel: ServiceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bound_service_demo)
        mViewModel = ViewModelProviders.of(this)[ServiceViewModel::class.java]

        mViewModel.binder.observe(this) {
            it?.let {myBinder->
                myService = myService.getService()
            }
        }

        binding.progressBtn.setOnClickListener{

        }
    }

    override fun onResume() {
        super.onResume()
        startService()
    }

    override fun onPause() {
        super.onPause()
        if(mViewModel.binder != null){
            Log.d("TAG", "onPause: Connected to service")
            unbindService(mViewModel.serviceConnection)
        }
        else{
            Log.d("TAG", "onPause: unBound to service")
            myService = null!!
        }
    }

    private fun startService() {
        val serviceIntent = Intent(this, MyService::class.java)
        startService(serviceIntent)
        bindService()
    }

    private fun bindService() {
        val serviceIntent = Intent(this, MyService::class.java)
        bindService(serviceIntent, mViewModel.serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun toggleUpdates(){

    }


}