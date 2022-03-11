package com.example.allinoneapppractise.sample_acurovet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.LayoutToolbarBinding
import com.google.android.material.textview.MaterialTextView
import kotlin.math.log

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var toolbarBinding: LayoutToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        toolbarBinding = DataBindingUtil.setContentView(this, R.layout.layout_toolbar)
        showOnlineOfflineBanner()
    }

    abstract fun getView(): MaterialTextView

    fun showOnlineOfflineBanner() {
        NetworkUtils.getNetworkLiveData().observe(this) {
            if (!it) {
                getView().visibility = View.VISIBLE
            } else {
                getView().visibility = View.GONE
            }
        }
    }

}