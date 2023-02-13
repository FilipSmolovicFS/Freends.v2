package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.practice.databinding.BottomSheetBinding
import com.example.practice.overview.OverviewViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.concurrent.fixedRateTimer

class BottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetBinding
    private lateinit var viewModel : OverviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetBinding.inflate(inflater,container,false)

        viewModel = ViewModelProvider(this)[OverviewViewModel::class.java]

        binding.submit.setOnClickListener {
            val bundle = Bundle()
            val editText = binding.changeUsername
            bundle.putString("username", editText.text.toString())
            val profile = ProfileFragment()
            profile.arguments = bundle
            dismiss()
        }
        return binding.root
    }


}