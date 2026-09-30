package com.altaf.manipursinghamlast.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.altaf.manipursinghamlast.R
import com.altaf.manipursinghamlast.common.base.BaseFragment
import com.altaf.manipursinghamlast.common.extension.navigateWithAnimation
import com.altaf.manipursinghamlast.common.extension.shareApp
import com.altaf.manipursinghamlast.databinding.FragmentHomeBinding
import com.altaf.manipursinghamlast.ui.home.viewmodel.HomeEvent
import dagger.hilt.android.AndroidEntryPoint
import com.altaf.manipursinghamlast.ui.home.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "onViewCreated: ")
        // Set up data binding
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()

    }

    override fun setupObservers() {
        super.setupObservers()

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiEvent.collect { event ->
                when (event) {
                    is HomeEvent.LastJodiNumberClick -> {
                        findNavController().navigateWithAnimation(R.id.lastJodiNumberFragment)
                    }
                    is HomeEvent.LastNumberClick -> {
                        findNavController().navigateWithAnimation(R.id.lastNumberFragment)
                    }
                    is HomeEvent.NumberCombinationClick -> {
                        findNavController().navigateWithAnimation(R.id.numberCombinationFragment)
                    }
                    is HomeEvent.ShowResultClick -> {
                        findNavController().navigateWithAnimation(R.id.showResultFragment)
                    }
                    is HomeEvent.ShareAppClick -> {
                        requireContext().shareApp()
                    }
                    is HomeEvent.Empty -> {
                        // No action needed for Empty event
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
