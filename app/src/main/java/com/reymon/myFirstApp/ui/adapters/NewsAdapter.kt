package com.reymon.myFirstApp.ui.adapters

import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.data.network.entities.topNews.Data
import com.reymon.myFirstApp.databinding.ItemTopNewsBinding

class NewsAdapter(private val itemList: List<Data>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        private val binding = ItemTopNewsBinding.bind(view)
        fun render(data: Data) {
            binding.txtTitleNews.text = data.title.toString()
            binding.txtDescNews.text = data.description.toString()
            binding.txtUrlNews.text = data.url.toString()
            binding.imgTopNews.load("https://sm.ign.com/ign_latam/screenshot/default/7bfbb86d1ef7aeb11ce16898521c0604_krp6.jpg")
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