package com.example.allinoneapppractise

import android.app.Application
import com.example.allinoneapppractise.didemo.DaggerSmartPhoneComponent
import com.example.allinoneapppractise.didemo.MemoryCardModule
import com.example.allinoneapppractise.didemo.SmartPhoneComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.DaggerMovieComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.MovieComponent

class MovieApplicationClass : Application() {
    lateinit var smartPhoneComponent: SmartPhoneComponent
    lateinit var movieComponent: MovieComponent

    override fun onCreate() {
        super.onCreate()
        movieComponent = initDaggerMovieComponent()
        smartPhoneComponent = initDaggerSmartPhoneComponent()
    }

    private fun initDaggerMovieComponent(): MovieComponent = DaggerMovieComponent.factory().create(applicationContext)

    private fun initDaggerSmartPhoneComponent(): SmartPhoneComponent {
        return DaggerSmartPhoneComponent.builder().memoryCardModule(MemoryCardModule(20)).build()
    }
}