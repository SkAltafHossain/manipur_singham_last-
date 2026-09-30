package com.altaf.manipursinghamlast.ui.numberCombination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.altaf.manipursinghamlast.R
import com.altaf.manipursinghamlast.common.base.BaseFragment
import com.altaf.manipursinghamlast.databinding.FragmentNumberCombinationBinding
import com.altaf.manipursinghamlast.ui.numberCombination.adapter.NumberCombinationAdapter
import com.altaf.manipursinghamlast.ui.numberCombination.viewmodel.NumberCombinationViewModel
import com.altaf.manipursinghamlast.ui.numberCombination.viewmodel.NumberCombinationEvent
import com.altaf.manipursinghamlast.ui.numberCombination.viewmodel.NumberCombinationState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NumberCombinationFragment : BaseFragment<NumberCombinationViewModel, FragmentNumberCombinationBinding>() {

    private val adapter by lazy { NumberCombinationAdapter() }

    override fun getViewModelClass(): Class<NumberCombinationViewModel> = NumberCombinationViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNumberCombinationBinding = FragmentNumberCombinationBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        setupRecyclerView()
        setupSearch()
        observeViewModel()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun setupSearch() {
        binding.btnSearch.setOnClickListener {
            val query = binding.etSearch.text?.toString().orEmpty()
            if (query.length == 4 && query.all { it.isDigit() }) {
                // Hide keyboard
                val imm = requireContext().getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
                imm.hideSoftInputFromWindow(binding.etSearch.windowToken, 0)
                
                viewModel.onSearchQueryChanged(query)
            } else {
                binding.etSearch.error = "Please enter a 4-digit number"
            }
        }

        // Optional: Clear error when user starts typing
        binding.etSearch.addTextChangedListener {
            binding.etSearch.error = null
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is NumberCombinationState.Loading -> {
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.GONE
                            }
                            is NumberCombinationState.Success -> {
                                binding.recyclerView.visibility = View.VISIBLE
                                binding.errorView.visibility = View.GONE
                                adapter.submitList(state.data)
                            }
                            is NumberCombinationState.Error -> {
                                binding.recyclerView.visibility = View.GONE
                                binding.errorView.visibility = View.VISIBLE
                                binding.errorText.text = state.message
                            }
                            is NumberCombinationState.Empty -> {
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
                            is NumberCombinationEvent.ShowError -> {
                                // Optionally show snackbar/toast if you have an extension
                            }
                            NumberCombinationEvent.Empty -> {}
                        }
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