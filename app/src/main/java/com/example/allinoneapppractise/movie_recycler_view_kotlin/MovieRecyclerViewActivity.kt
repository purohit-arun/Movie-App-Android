package com.example.allinoneapppractise.movie_recycler_view_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.custom_movie_array_adapter_kotlin.Movie
import com.example.allinoneapppractise.custom_movie_array_adapter_kotlin.MovieAdapter
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding

class MovieRecyclerViewActivity : AppCompatActivity() {
    lateinit var binding:ActivityMovieRecyclerViewBinding
    lateinit var mAdapter: MovieRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movie_recycler_view)
        val movieRecyclerView = findViewById<RecyclerView>(R.id.movie_rv)
        val mList = ArrayList<Movie>()
        movieRecyclerView.layoutManager = LinearLayoutManager(this)

        mList.add(
            Movie(
                R.drawable.ic_launcher_background,
                mName = "After Earth",
                mRelease = "2013"
            )
        )
        mList.add(Movie(mName = "Baby Driver", mRelease = "2016"))
        mList.add(Movie(mName = "Deadpool", mRelease = "1997"))
        mList.add(Movie(mName = "Deadpool", mRelease = "2005"))
        mList.add(Movie(mName = "Jaws", mRelease = "1254"))
        mList.add(Movie(mName = "After Earth", mRelease = "1547"))


        mAdapter = MovieRecyclerViewAdapter(this, mList)
        movieRecyclerView.adapter = mAdapter

    }
}