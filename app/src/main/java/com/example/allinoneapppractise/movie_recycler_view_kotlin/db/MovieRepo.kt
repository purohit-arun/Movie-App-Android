package com.example.allinoneapppractise.movie_recycler_view_kotlin.db

import androidx.lifecycle.LiveData

class MovieRepo(private val dao: MovieDao) {

    val moviesList = dao.getAllMovies()

    suspend fun insertMovie(movie: Movie):Long {
        return dao.insertMovie(movie)
    }

    suspend fun updateMovie(movie: Movie): Int {
        return dao.updateMovie(movie)
    }

    suspend fun deleteMovie(movie: Movie): Int {
        return dao.deleteMovie(movie)
    }

    suspend fun getMovies() {
        dao.getAllMovies()
    }
}