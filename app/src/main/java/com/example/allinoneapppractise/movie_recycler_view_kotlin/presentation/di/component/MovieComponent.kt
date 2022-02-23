package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.component

import android.app.Application
import android.content.Context
import com.example.allinoneapppractise.MovieApplicationClass
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub.MovieViewModelSubComponent
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.Sub.SubComponentModule
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules.APIDataSourceModule
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules.DBDataSourceModule
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules.DataSourceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        DataSourceModule::class,
        SubComponentModule::class,
        DBDataSourceModule::class,
        APIDataSourceModule::class
    ]
)
@Singleton
interface MovieComponent : AndroidInjector<MovieApplicationClass> {
    //fun inject(movieListFragment: MovieListFragment)

    fun MovieViewModelSubComponent(): MovieViewModelSubComponent.Factory

    //to make factory
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): MovieComponent
    }
}