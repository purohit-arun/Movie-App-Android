package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo.MovieRepo
import com.example.retrofitdemo.retrofit_practise.MovieRetrofitInstance
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.remote.MovieService
import kotlinx.coroutines.*

class MovieRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieRecyclerViewBinding
    lateinit var mAdapter: MovieRecyclerViewAdapter
    lateinit var myMovieViewModel: MovieActivtiyViewModel
    lateinit var movieService: MovieService
    lateinit var movieList: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_recycler_view)

        binding.progressBar.visibility = View.VISIBLE
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
            binding.progressBar.visibility = View.INVISIBLE
        })
    }

    /**
     * when the user click on the the movie
     */

    private fun movieItemClicked(movieItem: Movie) {
        Toast.makeText(this, movieItem.movie_name, Toast.LENGTH_SHORT).show()
        myMovieViewModel.initInsertAndUpdate(movieItem)
    }

}