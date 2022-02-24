package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules

import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieRecyclerViewActivity
import dagger.Component
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract fun contributeMovieActivity(): MovieRecyclerViewActivity
}