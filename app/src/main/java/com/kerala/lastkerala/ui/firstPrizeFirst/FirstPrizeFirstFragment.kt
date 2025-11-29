package com.kerala.lastkerala.ui.firstPrizeFirst

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.kerala.lastkerala.R
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.common.extension.showErrorSnackBar
import com.kerala.lastkerala.databinding.FragmentFirstPrizeFirstBinding
import com.kerala.lastkerala.ui.firstPrizeFirst.adapter.FirstPrizeFirstAdapter
import com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel.FirstPrizeFirstEvent
import com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel.FirstPrizeFirstState
import com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel.FirstPrizeFirstViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FirstPrizeFirstFragment : BaseFragment<FirstPrizeFirstViewModel, FragmentFirstPrizeFirstBinding>() {

    private val firstPrizeFirstAdapter by lazy { FirstPrizeFirstAdapter() }
    
    override fun getViewModelClass(): Class<FirstPrizeFirstViewModel> = FirstPrizeFirstViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentFirstPrizeFirstBinding = FragmentFirstPrizeFirstBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = firstPrizeFirstAdapter
            setHasFixedSize(true)
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is FirstPrizeFirstState.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.GONE
                            }
                            is FirstPrizeFirstState.Success -> {
                                binding.progressBar.visibility = View.GONE
                                binding.recyclerView.visibility = View.VISIBLE
                                binding.errorView.visibility = View.GONE
                                firstPrizeFirstAdapter.submitList(state.data)
                            }
                            is FirstPrizeFirstState.Error -> {
                                binding.progressBar.visibility = View.GONE
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.VISIBLE
                                showErrorSnackbar(state.message)
                            }
                            FirstPrizeFirstState.Empty -> {
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
                            is FirstPrizeFirstEvent.ShowError -> {
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
