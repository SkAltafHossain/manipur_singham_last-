package com.kerala.lastkerala.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import com.kerala.lastkerala.ui.home.viewmodel.HomeViewModel


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up data binding
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
