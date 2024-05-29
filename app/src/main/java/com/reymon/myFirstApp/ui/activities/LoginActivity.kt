package com.reymon.myFirstApp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.reymon.myFirstApp.databinding.ActivityLoginBinding
import com.reymon.myFirstApp.logic.usercases.GetAllCharactersUserCase
import com.reymon.myFirstApp.logic.usercases.GetAllTopsNewUserCase

import com.reymon.myFirstApp.ui.fragments.SignUpFragment

import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnGetStarted.setOnClickListener {
            Log.d("logIn", "Presionando el txt_logIN")
            replaceFragment(SignUpFragment())
        }
        binding.txtLogIn.setOnClickListener {
            //Como dijimos en el endpoint que vamos a utilizar una corrutina. Creamos el ambiente para esta
            lifecycleScope.launch(Dispatchers.IO) {
                GetAllCharactersUserCase().invoke()
            }

        }
        binding.txtLogo.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addSharedElement(binding.loginLayout, "signUp_element_container")
            .replace(binding.loginLayout.id, fragment)
            .commit()
    }

}