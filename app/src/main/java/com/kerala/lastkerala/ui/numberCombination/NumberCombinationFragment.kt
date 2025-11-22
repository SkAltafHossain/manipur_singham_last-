package com.kerala.lastkerala.ui.numberCombination

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerala.lastkerala.R
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentNumberCombinationBinding
import com.kerala.lastkerala.ui.numberCombination.viewmodel.NumberCombinationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberCombinationFragment : BaseFragment<NumberCombinationViewModel, FragmentNumberCombinationBinding>() {
    
    override fun getViewModelClass(): Class<NumberCombinationViewModel> = NumberCombinationViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentNumberCombinationBinding = FragmentNumberCombinationBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
