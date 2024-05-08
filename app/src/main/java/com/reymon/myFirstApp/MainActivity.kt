package com.reymon.myFirstApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        initListeners()


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
          var r = LoginUsercase()
          var result = r(
              binding.etxtUser.toString(),
              binding.etxtPass.toString()
          )
          result.onSuccess {
              var a = Intent(this, LoginActivity::class.java)
              a.putExtra("idUser", it)
              startActivity(a)
          }
          result.onFailure{
              Toast.makeText(this, it.message.toString(), Toast.LENGTH_SHORT).show()
          }
      }
    }
}