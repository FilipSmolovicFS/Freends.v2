package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.practice.R
import com.example.practice.databinding.LoginBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class LoginFragment:Fragment() {

    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater,container,false)
        val root:View = binding.root
        binding.submitButton.setOnClickListener {
            /*KAKO BI SE KREIRANI INTERFACE PROSLEDIO UNUTAR MAIN ACTIVITY*/
            (requireActivity() as MainActivity).onLoginBtnClicked()
        }

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        view.visibility = View.GONE



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*Ukoliko hocu da radim da mi se sa login-a prebaci na glavni deo aplikacije kreiram interface
    * sa funkcijom koju koristim dalje u setOnClickListener i unutar MainActivity*/
    interface LoginFragmentInterface{
        fun onLoginBtnClicked()
    }
}