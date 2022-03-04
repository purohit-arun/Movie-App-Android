package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub

import com.example.allinoneapppractise.MovieApplicationClass
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MovieViewModelSubModule::class])
interface MovieViewModelSubComponent : AndroidInjector<MovieApplicationClass> {
    fun inject(movieListFragment: MovieListFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieViewModelSubComponent
    }
}