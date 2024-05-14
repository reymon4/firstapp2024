package com.reymon.myFirstApp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.reymon.myFirstApp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners(){
        binding.txtLogIn.setOnClickListener {
            Log.d("logIn", "Presionando el txt_logIN")
            var a = Intent(this, MainActivity::class.java)
            startActivity(a)
        }
    }
}