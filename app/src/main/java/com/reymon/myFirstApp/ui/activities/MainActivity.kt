package com.reymon.myFirstApp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.carousel.CarouselLayoutManager
import com.reymon.myFirstApp.databinding.ActivityMainBinding
import com.reymon.myFirstApp.logic.usercases.GetAllTopsNewUserCase
import com.reymon.myFirstApp.ui.adapters.NewsAdapter
import com.reymon.myFirstApp.ui.entities.NewsDataUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
        private  var items = ArrayList<NewsDataUI>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initRecyclerView(items)
    }
    private fun initRecyclerView(items: List<NewsDataUI>){
        binding.rvTopNews.adapter = NewsAdapter(items)
        binding.rvTopNews.layoutManager = CarouselLayoutManager()
    }
    private fun initData(){
        lifecycleScope.launch(Dispatchers.IO) {
            binding.progressBar.visibility = View.VISIBLE
            val resultItems = GetAllTopsNewUserCase().invoke()
            withContext(Dispatchers.Main){
                binding.progressBar.visibility = View.INVISIBLE

                resultItems.onSuccess {
              initRecyclerView(it!!.toList())
            }
            resultItems.onFailure{
                initRecyclerView(emptyList())
            }
        }
        }

    }
    override fun onStart() {
        super.onStart()
        Log.d("Start activity", "onStart() del activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Resume activity", "onResume() del activity")
    }

    //private fun initListeners(){
    /* binding.btnLogin.setOnClickListener{
         var loginUsercase = LoginUsercase(ListUsers())
         var result = loginUsercase(
             binding.etxtUser.toString(),
             binding.etxtPass.toString()
         )
         result.onSuccess {user ->
             var a = Intent(this, LoginActivity::class.java)
             a.putExtra("idUser", user.id)
             startActivity(a)
         }
         result.onFailure{
             Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
         }
     }
   //}
   }
     */
}