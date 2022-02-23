package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di.modules

import android.content.Context
import androidx.room.Room
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.db.MovieDao
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.db.MovieDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

//Provides the dependency related to the database(room)
@Module
class DBDataSourceModule {

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

}