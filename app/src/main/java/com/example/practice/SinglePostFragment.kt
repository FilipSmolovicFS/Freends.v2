package com.example.practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.practice.databinding.SinglePostLayoutBinding

class SinglePostFragment: Fragment() {

    private var binding : SinglePostLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = SinglePostLayoutBinding.inflate(inflater,container,false)
        val root = binding?.root

        return root
    }
}