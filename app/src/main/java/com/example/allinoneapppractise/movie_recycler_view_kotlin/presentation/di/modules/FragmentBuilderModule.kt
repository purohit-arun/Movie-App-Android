package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules

import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment
}