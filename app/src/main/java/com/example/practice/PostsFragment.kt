package com.example.practice

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.practice.databinding.PostsPageBinding
import com.example.practice.overview.OverviewViewModel
import com.example.practice.overview.PhotoGridAdapter
import com.example.practice.overview.PostsAdapter
import com.example.practice.overview.RecyclerViewInterface
import com.google.android.material.bottomnavigation.BottomNavigationView

class PostsFragment: androidx.fragment.app.Fragment(), PostsAdapter.PostsAdapterInterface {

    private var _binding: PostsPageBinding? = null
    private val binding get() = _binding
    private val navController = NavController

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PostsPageBinding.inflate(inflater,container,false)
        val root = binding?.root

        val view = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        view.visibility = View.VISIBLE

        binding?.lifecycleOwner = this

        binding?.viewModel = viewModel

        binding?.postsList?.adapter = PostsAdapter(this)

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onImageClicked() {
        (requireActivity() as MainActivity).onNavigation(SinglePostFragment())
    }

    interface PostsFragmentInterface {
        fun onNavigation(fragment: Fragment)
    }

}