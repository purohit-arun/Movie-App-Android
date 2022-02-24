package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub

import android.content.Context
import com.example.allinoneapppractise.MovieApplicationClass
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MovieViewModelSubModule::class])
interface MovieViewModelSubComponent : AndroidInjector<MovieApplicationClass> {
//    fun inject(movieListFragment: MovieListFragment)

    //Factory is used to create instances of this subcomponent
//    @Subcomponent.Factory
//    interface Factory {
//        fun create(@BindsInstance context: Context): MovieViewModelSubComponent
//    }
    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<MovieApplicationClass>
}