package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.moviedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.allinoneapppractise.databinding.FragmentMovieDetailBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie

class MovieDetailFragment : Fragment() {
    private val args by navArgs<MovieDetailFragmentArgs>()
    private lateinit var fragmentMovieDetailBinding: FragmentMovieDetailBinding

    companion object {
        private const val MOVIE = "movie"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentMovieDetailBinding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        //val movie = requireArguments().getSerializable(MOVIE) as Movie
        return fragmentMovieDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentMovieDetailBinding.movieDetailModel = args.selectedMovie

    }
}


