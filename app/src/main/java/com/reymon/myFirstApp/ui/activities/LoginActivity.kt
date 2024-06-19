package com.reymon.myFirstApp.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetBehavior

import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.databinding.ActivityLoginBinding
import com.reymon.myFirstApp.ui.entities.DataStoreEntity

import com.reymon.myFirstApp.ui.fragments.LogInFragment

import com.reymon.myFirstApp.ui.fragments.SignUpFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginActivity : AppCompatActivity() {

    val Context.settingsDataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
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
        val splash = installSplashScreen()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        Thread.sleep(2000)
        //VERIFICAR LA INSTALACIÓN DE SPLASH
        splash.setKeepOnScreenCondition { false }
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

    private fun saveDataStore(user: DataStoreEntity) {

        //SAVE
        lifecycleScope.launch(Dispatchers.IO) {
            settingsDataStore.edit { prefs ->
                prefs[booleanPreferencesKey("active")] = false
                prefs[stringPreferencesKey("user")] = "Reymon"

            }
        }
    }

    private fun getDataStore(): String {
        //GET
        var aux: DataStoreEntity? = null
        lifecycleScope.launch(Dispatchers.Main) {
            val x = withContext(Dispatchers.IO) {
                settingsDataStore.data.map { prefs ->
                    DataStoreEntity(
                        prefs[stringPreferencesKey(name = "user")] ?: "",
                        prefs[stringPreferencesKey(name = "password")] ?: ""
                    )
                }
            }
            //Como esto es un flow (flujo de datos) lo que hago es recolectar los datos
            aux = x.first()
//            x.collect {
//                Log.d("DataStore", it)
//            }

        }
        return aux.toString()
    }

}