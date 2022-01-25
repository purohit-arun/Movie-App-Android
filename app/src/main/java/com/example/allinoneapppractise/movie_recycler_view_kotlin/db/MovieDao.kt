package com.example.allinoneapppractise.movie_recycler_view_kotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovie(movie:Movie):Long

    @Update
    suspend fun updateMovie(movie: Movie):Int

    @Delete
    suspend fun deleteMovie(movie: Movie):Int

    @Query("select * from movie_table")
    fun getAllMovies():LiveData<List<Movie>>

}