package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.component

import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules.APIDataSourceModule
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules.DBDataSourceModule
import dagger.Component

@Component(
    modules = [
        DBDataSourceModule::class,
        APIDataSourceModule::class
    ]
)
interface DataSourceSubcomponent {
}