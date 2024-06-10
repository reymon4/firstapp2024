package com.reymon.myFirstApp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.transition.MaterialContainerTransform
import com.reymon.myFirstApp.databinding.FragmentLogInBinding
import com.reymon.myFirstApp.logic.tmdb.GetAllTopRatedUsercase
import com.reymon.myFirstApp.ui.activities.DashboardActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LogInFragment : Fragment() {
    private lateinit var binding: FragmentLogInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedElementEnterTransition = MaterialContainerTransform()
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        initListeners()
        return binding.root

    }

    private fun initListeners() {
        binding.btnLogIn.setOnClickListener {
            /* Log.d("BTN LOg IN", "Presionando...")
                 lifecycleScope.launch(Dispatchers.IO) {
                     GetAllTopRatedUsercase().invoke()
                 }*/
            startActivity(Intent(requireContext(), DashboardActivity::class.java))
        }
    }

}