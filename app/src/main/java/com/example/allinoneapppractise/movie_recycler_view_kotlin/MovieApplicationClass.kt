package com.example.allinoneapppractise.movie_recycler_view_kotlin

import android.app.Application
import com.example.allinoneapppractise.movie_recycler_view_kotlin.di.DaggerMovieComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.di.MovieComponent

class MovieApplicationClass : Application() {
    companion object {
        var component: MovieComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerMovieComponent.factory().create(applicationContext)
    }

}