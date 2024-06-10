package com.reymon.myFirstApp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.core.Constants
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.Result as ResultMovie
import com.reymon.myFirstApp.databinding.ItemMovieBinding
import kotlinx.coroutines.withContext

class TopRatedDiffUtilAdapter() : ListAdapter<ResultMovie, TopRatedDiffUtilAdapter.TopRatedVH>(
    DiffUtilTopRatedCallback
) {
    class TopRatedVH(view: View) : RecyclerView.ViewHolder(view) {
        private val binding: ItemMovieBinding = ItemMovieBinding.bind(view)

        fun render(item: ResultMovie) {

            binding.txtTitle.text = item.title
            Glide.with(binding.root).load("${Constants.TMDB_IMAGE_URL}${item.poster_path}")
                .into(binding.imgMovie)
            binding.txtVoteAverage.text = item.vote_average.toString()
        }
    }

    private object DiffUtilTopRatedCallback : DiffUtil.ItemCallback<ResultMovie>() {
        override fun areItemsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultMovie, newItem: ResultMovie): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedVH {
        val inflater = LayoutInflater.from(parent.context)
        return TopRatedVH(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: TopRatedVH, position: Int) {
        holder.render(getItem(position))
    }
}