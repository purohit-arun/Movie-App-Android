package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist.MovieListFragment

class MovieRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding: ActivityMovieRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_recycler_view)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.movie_list_fragment_container, MovieListFragment())
                .commit()
        }
    }


}