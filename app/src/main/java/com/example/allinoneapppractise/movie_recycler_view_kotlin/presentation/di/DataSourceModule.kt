package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.di

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.db.MovieDao
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.db.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.api.MovieService
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repository.MovieRepo
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.api.MovieRetrofitInstance
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieActivtiyViewModel
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieViewModelFactoy
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import com.google.gson.GsonBuilder
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

    @Provides
    fun providesMovieRepo(dao: MovieDao, retrofit: MovieService): MovieRepo {
        return MovieRepo(dao, retrofit)
    }

    @Provides
    fun providesMovieViewModelFactory(movieRepo: MovieRepo): MovieViewModelFactoy {
        return MovieViewModelFactoy(movieRepo)
    }

   /* @Provides
    fun providesMovieViewModel(
        movieListFragment: MovieListFragment,
        viewModelFactoy: MovieViewModelFactoy
    ): MovieActivtiyViewModel {
        return ViewModelProvider(movieListFragment, viewModelFactoy)[MovieActivtiyViewModel::class.java]
    }*/
}