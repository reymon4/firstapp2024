package com.reymon.myFirstApp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.databinding.ItemTopRatedBinding
import com.reymon.myFirstApp.ui.entities.MovieDataUI

class TopRatedAdapter():ListAdapter<MovieDataUI, TopRatedAdapter.TopRatedVH>(DiffUtilTopRatedCallback){
    class TopRatedVH(view: View) : RecyclerView.ViewHolder(view) {
        private var binding: ItemTopRatedBinding = ItemTopRatedBinding.bind(view)

        fun render(item: MovieDataUI){

        }
    }
    private object DiffUtilTopRatedCallback: DiffUtil.ItemCallback<MovieDataUI>() {
        override fun areItemsTheSame(oldItem: MovieDataUI, newItem: MovieDataUI): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieDataUI, newItem: MovieDataUI): Boolean {
            return oldItem == newItem
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedVH{
        val inflater = LayoutInflater.from(parent.context)
        return TopRatedVH(inflater.inflate(R.layout.item_top_rated, parent, false))
    }

    override fun onBindViewHolder(holder: TopRatedVH, position: Int) {
        holder.render(getItem(position))
    }
}