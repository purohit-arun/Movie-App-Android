package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.allinoneapppractise.databinding.FragmentMovieDetailBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie

class MovieDetailFragment : Fragment() {

    companion object{
        private const val MOVIE = "movie"
        fun newInstance(movie:Movie): MovieDetailFragment {
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