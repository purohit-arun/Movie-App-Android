package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di

import dagger.Component

@Component(
    modules = [
        DBDataSourceModule::class,
        APIDataSourceModule::class
    ]
)
class DataSourceSubcomponent {
}