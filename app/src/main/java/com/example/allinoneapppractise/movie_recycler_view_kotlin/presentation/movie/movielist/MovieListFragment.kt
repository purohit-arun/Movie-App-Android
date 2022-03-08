package com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.allinoneapppractise.MovieApplicationClass
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.FragmentMovieListBinding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieActivityViewModel
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieRecyclerViewAdapter
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.MovieViewModelFactory
import com.example.allinoneapppractise.movie_recycler_view_kotlin.presentation.movie.moviedetail.MovieDetailFragment
import javax.inject.Inject

class MovieListFragment : Fragment() {
    lateinit var mAdapter: MovieRecyclerViewAdapter
    lateinit var myMovieViewModel: MovieActivityViewModel
    private lateinit var movieListFragmentBinding: FragmentMovieListBinding

    @Inject
    lateinit var movieViewModelFactory: MovieViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        movieListFragmentBinding = FragmentMovieListBinding.inflate(inflater, container, false)
        return movieListFragmentBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieListFragmentBinding.progressBar.visibility = View.GONE
        val movieRecyclerView = movieListFragmentBinding.movieRv

        (requireActivity().application as MovieApplicationClass)
            .movieComponent.MovieViewModelSubComponent().create().inject(this)

        myMovieViewModel = ViewModelProvider(this, movieViewModelFactory)[MovieActivityViewModel::class.java]
        Toast.makeText(context, "", Toast.LENGTH_SHORT).show()
        movieListFragmentBinding.myMovieViewModel = myMovieViewModel
        movieListFragmentBinding.lifecycleOwner = this
        movieRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        mAdapter = MovieRecyclerViewAdapter(
            this@MovieListFragment.requireContext(), clickListener = { selectedMovie: Movie ->
                movieItemClicked(selectedMovie)
            }, onLongClickListener = {
                onLongClickMovieDelete(it)
            }
        )
        movieRecyclerView.adapter = mAdapter
        displayMovieInRecyclerView()

        // function to observe LiveData object of Movie
        myMovieViewModel.message.observe(viewLifecycleOwner, Observer { it ->
            it.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })

    }

    private fun displayMovieInRecyclerView() {
        myMovieViewModel.movie?.observe(viewLifecycleOwner, Observer {
            mAdapter.setListOfMovie(it)
            movieListFragmentBinding.progressBar.visibility = View.INVISIBLE
        })
    }


    /**
     * when the user click on the the movie
     */

    private fun movieItemClicked(movieItem: Movie) {
        Toast.makeText(requireContext(), movieItem.movie_name, Toast.LENGTH_SHORT).show()
        myMovieViewModel.initInsertAndUpdate(movieItem)

        // Details Fragment replaced in the activity if clicked on the movie
        val action =
            MovieListFragmentDirections.actionMovieListFragmentToMovieDetailFragment(
                movieItem
            )
        view?.findNavController()?.navigate(action)

    }


    /**
     * To delete the movie :  when user long click the movie list item
     */


    private fun onLongClickMovieDelete(movieItem: Movie) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Delete the movie")

        alertDialog.setMessage("Are You sure??")
            .setCancelable(true)
            .setPositiveButton("Yes") { _, _ ->
                myMovieViewModel.deleteMovie(movieItem)
                Toast.makeText(requireContext(), "$movieItem deleted", Toast.LENGTH_SHORT).show()
            }

        alertDialog.show()
    }
}