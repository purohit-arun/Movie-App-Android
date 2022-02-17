package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.content.Context
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataSourceModule::class])
interface MovieComponent {
    fun inject(movieListFragment: MovieListFragment)

    //to make factory
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : MovieComponent
    }
}