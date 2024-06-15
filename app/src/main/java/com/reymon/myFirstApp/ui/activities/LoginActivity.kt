package com.reymon.myFirstApp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.databinding.ActivityLoginBinding

import com.reymon.myFirstApp.ui.fragments.LogInFragment

import com.reymon.myFirstApp.ui.fragments.SignUpFragment


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Enable Activity Transitions. Optionally enable Activity transitions in your
        // theme with <item name=”android:windowActivityTransitions”>true</item>.
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        // Attach a callback used to capture the shared elements from this Activity to be used
        // by the container transform transition
        setExitSharedElementCallback(MaterialContainerTransformSharedElementCallback())

        // Keep system bars (status bar, navigation bar) persistent throughout the transition.
        window.sharedElementsUseOverlay = false
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
    }

    private fun initListeners() {
        binding.btnGetStarted.setOnClickListener {
            Log.d("logIn", "Presionando el txt_logIN")
            /*
                        binding.loginLayout.setBackgroundColor(resources.getColor(R.color.white))
                        binding.btnGetStarted.visibility = View.GONE
                        binding.txtLogIn.setTextColor(resources.getColor(R.color.black))
                        replaceFragment(SignUpFragment())*/
            val modalBottomSheet = SignUpFragment()
            modalBottomSheet.show(supportFragmentManager, modalBottomSheet.tag)


        }
        binding.txtLogIn.setOnClickListener {
            //Como dijimos en el endpoint que vamos a utilizar una corrutina. Creamos el ambiente para esta
            /*  lifecycleScope.launch(Dispatchers.IO) {
                  GetAllCharactersUserCase().invoke()
              }*/
            replaceFragment(LogInFragment())
            binding.loginLayout.setBackgroundColor(resources.getColor(R.color.black))
           // binding.btnGetStarted.visibility = View.GONE
            binding.txtLogIn.setTextColor(resources.getColor(R.color.white))


        }
        binding.txtLogo.setOnClickListener {
            startActivity(
                Intent(this, this::class.java)
            )
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
            // transaction.addSharedElement(binding.loginLayout, "signUp_element_container")
            .replace(binding.fragmentContainer.id, fragment)
            //Con esto agrego al fragment a la pila de navegación
            .addToBackStack(null)
            .commit()
    }

}