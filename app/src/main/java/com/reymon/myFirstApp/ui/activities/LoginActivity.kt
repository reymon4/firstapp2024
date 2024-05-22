package com.reymon.myFirstApp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.reymon.myFirstApp.databinding.ActivityLoginBinding
import com.reymon.myFirstApp.logic.usercases.GetAllCharactersUserCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.txtLogIn.setOnClickListener {
            Log.d("logIn", "Presionando el txt_logIN")
            var a = Intent(this, MainActivity::class.java)
            startActivity(a)
        }
        binding.btnGetStarted.setOnClickListener {
            //Como dijimos en el endpoint que vamos a utilizar una corrutina. Creamos el ambiente para esta
            lifecycleScope.launch(Dispatchers.IO) {
                GetAllCharactersUserCase().invoke()
            }

        }
    }
}