package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie

import androidx.lifecycle.*
import com.example.allinoneapppractise.custom_movie_array_adapter_kotlin.Event
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.db.MovieDao
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repository.MovieRepo
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.*
import javax.inject.Inject

class MovieActivityViewModel(
    private val repository: MovieRepo
) : ViewModel() {
    private val statusMessage = MutableLiveData<Event<String>>()
    val message: LiveData<Event<String>>
        get() = statusMessage

    //livedata text for insert and delete button
    val buttonText = MutableLiveData<String>()
    val inputMovie = MutableLiveData<String?>()
    val inputReleaseDate = MutableLiveData<String?>()

    @Inject
    lateinit var dao: MovieDao


    var movie: LiveData<List<Movie>>? = repository.getMovies()

    /*  val movies = viewModelScope.launch {
          async {
              movie = repository.getMovies()
          }
      }*/
    init {
        buttonText.value = "Save Movie"
        /*viewModelScope.launch {
            val jobObject = repository.getMovies
            Log.i("   TAG", "Movie data: ${movie?.value}")
        }*/

    }


    /**
     * variable for status message to show on toast
     */


    private var isUpdateOrDeleteFlag = false
    private lateinit var movieToInsertOrUpdate: Movie

    //suspend fun getMovies() = withContext(Dispatchers.IO) { repository.getMovies() }


//    fun insertMovie() = viewModelScope.launch {
//        val moviename = inputMovie.value!!
//        val releaseDate = inputReleaseDate.value!!
//        repository.insertMovie(Movie(0, moviename, releaseDate))
//    }

    fun initInsertAndUpdate(movieItem: Movie) {
        inputMovie.value = movieItem.movie_name
        inputReleaseDate.value = movieItem.release_date
        isUpdateOrDeleteFlag = true
        movieToInsertOrUpdate = movieItem
        buttonText.value = "Update Movie"
    }


    /*fun updateOrInsertMovie() = viewModelScope.launch {
        if (inputMovie.value == null) {
            statusMessage.value = Event("Please Enter the movie name")
        } else if (inputReleaseDate.value == null) {
            statusMessage.value = Event("Please Enter the release date")
        } else {
            if (isUpdateOrDeleteFlag) {
                movieToInsertOrUpdate.movie_name = inputMovie.value!!
                movieToInsertOrUpdate.release_date = inputReleaseDate.value!!
                update(movieToInsertOrUpdate)
                isUpdateOrDeleteFlag = false
                buttonText.value = "Save Movie"
                inputMovie.value = null
                inputReleaseDate.value = null
            } else {
                insert(Movie(0, inputMovie.value.toString(), inputReleaseDate.value.toString()))
                inputMovie.value = null
                inputReleaseDate.value = null
            }
        }
    }*/

    /*fun insert(movie: Movie) = viewModelScope.launch {
        val newRowId: Long = repository.insertMovie(movie)
        if (newRowId > -1) {
            statusMessage.value = Event("Movie added successfully with id $newRowId")
        } else {
            statusMessage.value = Event("Error occurred")
        }
    }*/

    /*fun update(movie: Movie) = viewModelScope.launch {
        val noOfRowsChanged: Int = repository.updateMovie(movie)
        if (noOfRowsChanged > 0) {
            isUpdateOrDeleteFlag = false
            buttonText.value = "Save Movie"
            statusMessage.value = Event("$noOfRowsChanged Movie Updated")
        } else {
            statusMessage.value = Event("$noOfRowsChanged Movie updated")
        }
    }*/

    fun deleteMovie(movie: Movie) = viewModelScope.launch {
        val newRowId: Int = repository.deleteMovie(movie)
    }


}