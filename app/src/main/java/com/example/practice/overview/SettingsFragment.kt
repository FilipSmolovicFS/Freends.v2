package com.example.practice.overview

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.practice.BottomSheetFragment
import com.example.practice.MainActivity
import com.example.practice.ProfileFragment
import com.example.practice.R
import com.example.practice.databinding.SettingsPageBinding

class SettingsFragment:Fragment() {

    private var _binding: SettingsPageBinding? = null
    val binding get() = _binding

    private val bottomSheetFragment = BottomSheetFragment()

    private val viewModel : OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SettingsPageBinding.inflate(inflater,container,false)
        val root = binding?.root

        binding?.switch1?.setOnCheckedChangeListener { _, isChecked ->
            binding?.logout?.text = if (isChecked) "DarkMode" else "LightMode"
        }

        binding?.bottomSheet?.setOnClickListener{
            bottomSheetFragment.show(requireFragmentManager(),"exampleBottomSheet")
        }

        binding?.leave?.setOnClickListener{
            activity?.recreate()
        }

        val edit = binding.proba1.text.toString()

        binding?.dugmeProba?.setOnClickListener {

        }


        alertBox()
        return root
    }


    private fun alertBox(){
        binding?.logout?.setOnClickListener{
            val builder = AlertDialog.Builder(activity)
            builder.setTitle("Switch Light Mode")
            builder.setMessage("Light Mode?")

            builder.setPositiveButton("Yes"){dialogInterface, which->
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            builder.setNegativeButton("No"){dialogInterface, which->
                Toast.makeText(context,"Canceled",Toast.LENGTH_SHORT).show()
            }
            val alertDialog:AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }


}