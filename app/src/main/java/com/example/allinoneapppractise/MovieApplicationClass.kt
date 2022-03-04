package com.example.allinoneapppractise

import com.example.allinoneapppractise.didemo.DaggerSmartPhoneComponent
import com.example.allinoneapppractise.didemo.MemoryCardModule
import com.example.allinoneapppractise.didemo.SmartPhoneComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.component.DaggerMovieComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.component.MovieComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MovieApplicationClass : DaggerApplication() {
    lateinit var smartPhoneComponent: SmartPhoneComponent
    lateinit var movieComponent: MovieComponent
    override fun onCreate() {
        super.onCreate()
       movieComponent = initDaggerMovieComponent()
        smartPhoneComponent = initDaggerSmartPhoneComponent()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        return DaggerMovieComponent.factory().create(this)
    }

   private fun initDaggerMovieComponent(): MovieComponent = DaggerMovieComponent.factory().create(applicationContext)

    private fun initDaggerSmartPhoneComponent(): SmartPhoneComponent {
        return DaggerSmartPhoneComponent.builder().memoryCardModule(MemoryCardModule(20)).build()
    }
}