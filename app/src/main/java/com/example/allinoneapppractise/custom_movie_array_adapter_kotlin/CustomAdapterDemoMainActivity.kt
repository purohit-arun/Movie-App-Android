package com.example.allinoneapppractise.custom_movie_array_adapter_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.allinoneapppractise.R

class CustomAdapterDemoMainActivity : AppCompatActivity() {
    lateinit var mAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter_demo_main)

        val movieListView: ListView = findViewById(R.id.movie_lv)

        val mList = ArrayList<Movie>()

        mList.add(Movie(R.drawable.ic_launcher_background,mName = "After Earth", mRelease = "2013"))
        mList.add(Movie(mName = "Baby Driver", mRelease = "2016"))
        mList.add(Movie(mName = "Deadpool", mRelease = "1997"))
        mList.add(Movie(mName = "Deadpool", mRelease = "2005"))
        mList.add(Movie(mName = "Jaws", mRelease = "1254"))
        mList.add(Movie(mName = "After Earth", mRelease = "1547"))

        mAdapter = MovieAdapter(this, mList)
        movieListView.adapter = mAdapter
    }
}