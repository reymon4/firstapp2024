package com.reymon.myFirstApp.ui.fragments


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.transition.MaterialContainerTransform
import com.reymon.myFirstApp.R
import com.reymon.myFirstApp.databinding.FragmentSignUpBinding



class SignUpFragment : BottomSheetDialogFragment(){

    private lateinit var binding: FragmentSignUpBinding
    companion object {
        const val TAG = "ModalBottomSheetSignUp"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedElementEnterTransition = MaterialContainerTransform()
        binding = FragmentSignUpBinding.inflate(inflater, container, false)

        return binding.root
    }




}