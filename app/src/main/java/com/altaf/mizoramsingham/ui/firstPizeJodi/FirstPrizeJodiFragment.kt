package com.altaf.manipursinghamlast.ui.firstPizeJodi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.altaf.manipursinghamlast.R
import com.altaf.manipursinghamlast.common.base.BaseFragment
import com.altaf.manipursinghamlast.common.extension.showErrorSnackBar
import com.altaf.manipursinghamlast.databinding.FragmentFirstPrizeJodiBinding
import com.altaf.manipursinghamlast.ui.firstPizeJodi.adapter.FirstPrizeJodiAdapter
import com.altaf.manipursinghamlast.ui.firstPizeJodi.viewmodel.FirstPrizeJodiEvent
import com.altaf.manipursinghamlast.ui.firstPizeJodi.viewmodel.FirstPrizeJodiState
import com.altaf.manipursinghamlast.ui.firstPizeJodi.viewmodel.FirstPrizeJodiViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstPrizeJodiFragment : BaseFragment<FirstPrizeJodiViewModel, FragmentFirstPrizeJodiBinding>() {

    private val firstPrizeJodiAdapter by lazy { FirstPrizeJodiAdapter() }

    override fun getViewModelClass(): Class<FirstPrizeJodiViewModel> = FirstPrizeJodiViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstPrizeJodiBinding =
        FragmentFirstPrizeJodiBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = firstPrizeJodiAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is FirstPrizeJodiState.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.GONE
                            }
                            is FirstPrizeJodiState.Success -> {
                                binding.progressBar.visibility = View.GONE
                                binding.recyclerView.visibility = View.VISIBLE
                                binding.errorView.visibility = View.GONE
                                firstPrizeJodiAdapter.submitList(state.data)
                            }
                            is FirstPrizeJodiState.Error -> {
                                binding.progressBar.visibility = View.GONE
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.VISIBLE
                                showErrorSnackbar(state.message)
                            }
                            FirstPrizeJodiState.Empty -> {
                                binding.progressBar.visibility = View.GONE
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.VISIBLE
                                binding.errorText.text = getString(R.string.no_data_available)
                            }
                        }
                    }
                }

                launch {
                    viewModel.uiEvent.collect { event ->
                        when (event) {
                            is FirstPrizeJodiEvent.ShowError -> {
                                showErrorSnackbar(event.message)
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
    }

    private fun showErrorSnackbar(message: String) {
        binding.root.showErrorSnackBar(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}