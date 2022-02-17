package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDao
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo.MovieRepo
import com.example.retrofitdemo.retrofit_practise.MovieRetrofitInstance
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.remote.MovieService
import kotlinx.coroutines.*
import javax.inject.Inject

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