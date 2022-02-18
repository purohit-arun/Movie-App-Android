package com.example.allinoneapppractise.movie_recycler_view_kotlin.di

import android.content.Context
import androidx.room.Room
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDao
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.remote.MovieService
import com.example.retrofitdemo.retrofit_practise.MovieRetrofitInstance
import com.google.gson.GsonBuilder
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataSourceModule {

    // For Providing the object related to the room service
    @Provides
    @Singleton
    fun providesRoomDatabaseInstance(context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MovieDatabase::class.java,
            "movie_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(movieDatabase: MovieDatabase): MovieDao {
        return movieDatabase.movieDAO
    }


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