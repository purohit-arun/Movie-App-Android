package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub

import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repository.MovieRepo
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieViewModelSubModule {
    @Provides
    fun provideViewModelFactory(repository: MovieRepo): MovieViewModelFactory {
        return MovieViewModelFactory(repository)
    }
}