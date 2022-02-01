package com.example.allinoneapppractise.movie_recycler_view_kotlin.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.databinding.ListItemMovie2Binding
import com.example.allinoneapppractise.movie_recycler_view_kotlin.data.models.local.Movie

class MovieRecyclerViewAdapter(val context: Context, private val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MyViewHolder>() {

    //this list hold the list of movies
    val movieList = ArrayList<Movie>()


    class MyViewHolder(val binding: ListItemMovie2Binding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            binding.movieNameTv.text = movie.movie_name
            binding.releaseDateTv.text = movie.release_date
            binding.listItemLayout.setOnClickListener {
                clickListener(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemMovie2Binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_item_movie_2, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.bind(currentMovie, clickListener)

//        holder.movieName.text = currentMovie.movie_name
//        holder.movieReleaseDate.text = currentMovie.release_date
//        holder.posterImage.setImageResource(currentMovie.mImageDrawable)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun setListOfMovie(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }
}

//TODO: 1 Functionality -> Long press the movie list item to delete the movie from the list