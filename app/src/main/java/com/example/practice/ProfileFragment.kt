package com.example.practice


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.practice.databinding.ProfilePageBinding
import com.example.practice.overview.OverviewViewModel
import com.example.practice.overview.PhotoGridAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileFragment: Fragment() {

    private var _binding: ProfilePageBinding? = null
    private val binding get() = _binding
    private val navController = NavController


    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ProfilePageBinding.inflate(inflater,container,false)
        val root = binding?.root

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        view.visibility = View.VISIBLE

        binding?.lifecycleOwner = this

        binding?.viewModel = viewModel

        binding?.photosGrid?.adapter = PhotoGridAdapter()

//        binding?.textView2?.text = viewModel.test.toString()

        val test = viewModel.test.toString()
        binding?.textView2?.text = test

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}