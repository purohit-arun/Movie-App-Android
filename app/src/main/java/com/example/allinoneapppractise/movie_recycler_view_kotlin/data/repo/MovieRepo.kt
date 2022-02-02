package com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDao
import com.example.retrofitdemo.retrofit_practise.MovieService
import com.example.retrofitdemo.retrofit_practise.movie_data_classes.Movies
import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

class MovieRepo(
    private val dao: MovieDao,
    private val movieService: MovieService
) {

    //val moviesList = dao.getAllMovies()

    /* suspend fun insertMovie(movie: Movie):Long {
         return dao.insertMovie(movie)
     }

     suspend fun updateMovie(movie: Movie): Int {
         return dao.updateMovie(movie)
     }

     suspend fun deleteMovie(movie: Movie): Int {
         return dao.deleteMovie(movie)
     }*/

    val _list1 = MutableLiveData<List<Movie>>()
    val list1: LiveData<List<Movie>> = _list1

    val getMovies = dao.getAllMovies()

    /*suspend fun getMovies(): LiveData<List<Movie>> {
        val remoteMovieList = movieService.getShows()
        return if (remoteMovieList.isSuccessful) {
            remoteMovieList.body()?.let { it ->
                it.map {
                    Movie(
                        0,
                        it.name!!,
                        it.premiered!!,
                        it.rating?.average.toString(),
                        it.image?.medium!!
                    )
                }.also {
                    dao.insertListOfMovies(it)
                }
            }
            dao.getAllMovies()
        } else {
            list1
        }
    }*/
}