package com.reymon.myFirstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.reymon.myFirstApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Esta variable la declaramos y no la inicializamos hasta que se haga su primer llamado
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// AQUÍ LLAMAMOS POR PRIMERA VEZ A LA VARIABLE binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Inicializo el binding
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            if (binding.etxtUser.text.toString() == "admin" && binding.etxtPass.text.toString() == "admin") {
                initListeners()
                Snackbar.make(binding.etxtUser, "Bienvenido", Snackbar.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Datos mal ingresados, no sea imbecil", Toast.LENGTH_SHORT)
                    .show();
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

    private fun initListeners(){
        binding.btnLogin.setOnClickListener{

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }
    }
}