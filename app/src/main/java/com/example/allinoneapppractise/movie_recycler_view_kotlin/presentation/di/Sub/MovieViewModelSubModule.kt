package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub

import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repository.MovieRepo
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieViewModelFactoy
import dagger.Module
import dagger.Provides

@Module
class MovieViewModelSubModule {
    @Provides
    fun provideViewModelFactory(repository: MovieRepo): MovieViewModelFactoy {
        return MovieViewModelFactoy(repository)
    }
}