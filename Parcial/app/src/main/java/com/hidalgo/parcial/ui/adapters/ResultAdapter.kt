package com.hidalgo.parcial.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

import com.hidalgo.parcial.R
import com.hidalgo.parcial.data.network.entities.ResultMessage
import com.hidalgo.parcial.databinding.ItemMessageBinding


class ResultAdapter(private val itemList: List<ResultMessage>) :
    RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {
    class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMessageBinding.bind(view)
        fun render(data: ResultMessage) {
            binding.txtMessage.text = data.message
            binding.txtName.text = data.name
            Glide.with(binding.root)
                .load(data.profile_image)
                .transform(CircleCrop())
                .into(binding.imgMessage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ResultViewHolder(inflater.inflate(R.layout.item_message, parent, false))
    }

    override fun getItemCount() = itemList.size
    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.render(itemList[position])
    }


}