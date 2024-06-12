package com.hidalgo.parcial.ui.activities

import android.os.Bundle
import android.view.View

import androidx.appcompat.app.AppCompatActivity

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.hidalgo.parcial.data.network.entities.ResultMessage
import com.hidalgo.parcial.databinding.ActivityMainBinding
import com.hidalgo.parcial.logic.usercases.GetAllMessages
import com.hidalgo.parcial.ui.adapters.ResultAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var items = ArrayList<ResultMessage>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initRecyclerView(items)

    }

    private fun initRecyclerView(items: List<ResultMessage>) {
        binding.rvMessages.adapter = ResultAdapter(items)
        binding.rvMessages.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initData() {
        lifecycleScope.launch(Dispatchers.IO) {
            binding.progressBar.visibility = View.VISIBLE
            val resultItems = GetAllMessages().invoke()
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.INVISIBLE

                resultItems.onSuccess {
                    initRecyclerView(it!!.toList())
                }
                resultItems.onFailure {
                    initRecyclerView(emptyList())
                }
            }
        }

    }

}