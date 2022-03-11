package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment
import dagger.android.support.DaggerAppCompatActivity

class MovieRecyclerViewActivity : DaggerAppCompatActivity() {
    lateinit var binding: ActivityMovieRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_recycler_view)
        NavHostFragment.create(R.navigation.nav_graph)
    }
}