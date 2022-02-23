package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub

import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import dagger.Subcomponent

@Subcomponent(modules = [MovieViewModelSubModule::class])
interface MovieViewModelSubComponent {
    fun inject(movieListFragment: MovieListFragment)

    //Factory is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieViewModelSubComponent
    }
}