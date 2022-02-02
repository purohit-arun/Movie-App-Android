package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo.MovieRepo
import com.example.retrofitdemo.retrofit_practise.MovieRetrofitInstance
import com.example.retrofitdemo.retrofit_practise.MovieService
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MovieRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieRecyclerViewBinding
    lateinit var mAdapter: MovieRecyclerViewAdapter
    lateinit var myMovieViewModel: MovieActivtiyViewModel
    lateinit var movieService: MovieService
    lateinit var movieList: List<Movie>

    val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_recycler_view)


        val movieRecyclerView = binding.movieRv

        val dao = MovieDatabase.getInstance(application)?.movieDAO

        movieService = MovieRetrofitInstance
            .getRetrofitInstance()
            .create(MovieService::class.java)

        val repository = MovieRepo(dao!!, movieService)

        val factory = MovieViewModelFactoy(repository)
        myMovieViewModel = ViewModelProvider(this, factory)[MovieActivtiyViewModel::class.java]
        Toast.makeText(applicationContext, "", Toast.LENGTH_SHORT).show()
        binding.myMovieViewModel = myMovieViewModel
        binding.lifecycleOwner = this
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = MovieRecyclerViewAdapter(
            this@MovieRecyclerViewActivity,
        ) { selectedMovie: Movie -> movieItemClicked(selectedMovie) }
        movieRecyclerView.adapter = mAdapter

        displayMovieInRecyclerView()

        /*lifecycleScope.launch {
            withContext(Dispatchers.IO){
                val movies =  myMovieViewModel.movies.await()
                runOnUiThread {
                    mAdapter = MovieRecyclerViewAdapter(this@MovieRecyclerViewActivity, movies) { selectedMovie: Movie -> movieItemClicked(selectedMovie) }
                    movieRecyclerView.adapter = mAdapter
                }
            }
        }*/



        myMovieViewModel.message.observe(this, Observer { it ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

    }

    // function to observe LiveData object of Movie
    private fun displayMovieInRecyclerView() {
        myMovieViewModel.movie?.observe(this, Observer {
            mAdapter.setListOfMovie(it)
        })
    }

    /**
     * when the user click on the the movie
     */

    private fun movieItemClicked(movieItem: Movie) {
        Toast.makeText(this, movieItem.movie_name, Toast.LENGTH_SHORT).show()
        myMovieViewModel.initInsertAndUpdate(movieItem)
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
    }
}