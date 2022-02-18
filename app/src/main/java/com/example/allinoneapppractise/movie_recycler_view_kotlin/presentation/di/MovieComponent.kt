package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di

import android.content.Context
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [DataSourceModule::class])
@Singleton
interface MovieComponent {
    fun inject(movieListFragment: MovieListFragment)

    //to make factory
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : MovieComponent
    }
}