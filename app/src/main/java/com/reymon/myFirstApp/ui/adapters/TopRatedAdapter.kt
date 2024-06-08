package com.reymon.myFirstApp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.data.network.entities.tmdb.rated.Result
import com.reymon.myFirstApp.databinding.ItemMovieBinding

import com.reymon.myFirstApp.ui.entities.MovieDataUI

class TopRatedAdapter():ListAdapter<Result, TopRatedAdapter.TopRatedVH>(DiffUtilTopRatedCallback){
    class TopRatedVH(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemMovieBinding= ItemMovieBinding.bind(view)

        fun render(item: Result){
            binding.txtTitle.text = item.title
            binding.imgMovie.load(item.poster_path.toString()){
                crossfade(true)
                placeholder(R.drawable.background_monkey)
            }
        }
    }
    private object DiffUtilTopRatedCallback: DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedVH{
        val inflater = LayoutInflater.from(parent.context)
        return TopRatedVH(inflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: TopRatedVH, position: Int) {
        holder.render(getItem(position))
    }
}