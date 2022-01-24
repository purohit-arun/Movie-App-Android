package com.example.allinoneapppractise.movie_recycler_view_kotlin.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface MovieDao {
    @Insert
    suspend fun insertMovie(movie:Movie):Long

    @Update
    suspend fun updateMovie(movie: Movie):Int

    @Delete
    suspend fun deleteMovie(movie: Movie):Int

}