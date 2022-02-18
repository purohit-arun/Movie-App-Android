package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("app:src")
fun setImageResource(imageView:ImageView, url: String){
    imageView.load(url)
}