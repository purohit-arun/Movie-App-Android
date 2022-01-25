package com.example.allinoneapppractise.movie_recycler_view_kotlin

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allinoneapppractise.custom_movie_array_adapter_kotlin.Event
import com.example.allinoneapppractise.movie_recycler_view_kotlin.db.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.db.MovieRepo
import kotlinx.coroutines.launch

class MovieActivtiyViewModel(private val repository: MovieRepo) : ViewModel() {

    val inputMovie = MutableLiveData<String>()
    val inputReleaseDate = MutableLiveData<String>()
    val movies = repository.moviesList
    private var isUpdateOrDeleteFlag = false
    private lateinit var movieToUpdateOrDelete: Movie


    /**
    variable for status message to show on toast
     */
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>> = statusMessage

    //livedata text for insert and delete button
    val buttonText = MutableLiveData<String>()

    init {
        buttonText.value = "Save Movie"
    }


    fun insertMovie() = viewModelScope.launch {
        val moviename = inputMovie.value!!
        val releaseDate = inputReleaseDate.value!!
        repository.insertMovie(Movie(0, moviename, releaseDate))
    }

    fun initUpdateAndDelete(movieItem: Movie) {
        inputMovie.value = movieItem.movie_name
        inputReleaseDate.value = movieItem.release_date
        isUpdateOrDeleteFlag = true
        buttonText.value = "Update Movie"
    }


    fun updateMovie() = viewModelScope.launch {
        if (inputMovie.value == null) {
            statusMessage.value = Event("Please Enter the movie name")
        } else if (inputReleaseDate.value == null) {
            statusMessage.value = Event("Please Enter the release date")
        } else {
            if (isUpdateOrDeleteFlag) {
                movieToUpdateOrDelete.movie_name = inputMovie.value!!
                movieToUpdateOrDelete.release_date = inputMovie.value!!
                update(movieToUpdateOrDelete)
            }
            else{
                insert(Movie(0, inputMovie.value.toString(), inputReleaseDate.value.toString()))
            }
        }
    }

    fun insert(movie:Movie) = viewModelScope.launch{
        val newRowId :Long = repository.insertMovie(movie)
        if(newRowId > -1 ){
            statusMessage.value = Event("Movie added successfully with id $newRowId")
        }
        else{
            statusMessage.value = Event("Error occurred")
        }
    }

    fun update(movie: Movie) = viewModelScope.launch {
        val noOfRowsChanged: Int = repository.updateMovie(movie)
        if (noOfRowsChanged > 0) {
            isUpdateOrDeleteFlag = false
            buttonText.value = "Save Movie"
            statusMessage.value = Event("$noOfRowsChanged Movie Updated")
        } else {
            statusMessage.value = Event("$noOfRowsChanged Movie updated")
        }
    }
}