package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ActivityMovieRecyclerViewBinding
import com.example.allinoneapppractise.databinding.FragmentMovieDetailBinding
import com.example.allinoneapppractise.databinding.FragmentMovieListBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.local.MovieDatabase
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.data_source.remote.MovieService
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.repo.MovieRepo
import com.example.retrofitdemo.retrofit_practise.MovieRetrofitInstance

class MovieDetailFragment : Fragment() {

    companion object{
        private const val MOVIE = "movie"
        fun newInstance(movie:Movie): MovieDetailFragment{
            val args = Bundle()
            args.putSerializable(MOVIE, movie)
            val fragment = MovieDetailFragment()
            fragment.arguments = args
            return fragment
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentMovieDetailBinding = FragmentMovieDetailBinding.inflate(inflater,container, false)
        val movie = requireArguments().getSerializable(MOVIE) as Movie
        fragmentMovieDetailBinding.movieDetailModel = movie
        return fragmentMovieDetailBinding.root
    }
}