package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules

import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.api.MovieRetrofitInstance
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.api.MovieService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class APIDataSourceModule {

    // For Providing the object related to the retrofit service
    @Provides
    fun providesRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(MovieRetrofitInstance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Provides
    fun providesMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
    
}