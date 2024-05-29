package com.reymon.myFirstApp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.databinding.ItemTopNewsBinding
import com.reymon.myFirstApp.ui.entities.NewsDataUI

class NewsAdapter(private val itemList: List<NewsDataUI>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val binding = ItemTopNewsBinding.bind(view)
        fun render(data: NewsDataUI) {
            binding.txtTitleNews.text = data.name.toString()
            binding.txtDescNews.text = data.description.toString()
            binding.txtUrlNews.text = data.url.toString()
            binding.imgTopNews.load(data.image.toString()){
                crossfade(true)
                placeholder(R.drawable.background_monkey)
            }
            //Glide.with(binding.root).load(data.image_url).into(binding.imgTopNews)
        }

    }

    //Asignamos el layout de diseño genérico del elemnto
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        //Levantamos como objeto el layout que vamos a inflar (levantar)
        val inflater = LayoutInflater.from(parent.context)
        //Llamamos al viewHolder interno de esta clase
        return NewsViewHolder(inflater.inflate(R.layout.item_top_news, parent, false))
    }

    override fun getItemCount() = itemList.size
    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.render(itemList[position])
    }
}