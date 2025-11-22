package com.kerala.lastkerala.ui.numberPattern

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerala.lastkerala.R
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentNumberPatternBinding
import com.kerala.lastkerala.ui.numberPattern.viewmodel.NumberPatternViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberPatternFragment : BaseFragment<NumberPatternViewModel, FragmentNumberPatternBinding>() {
    
    override fun getViewModelClass(): Class<NumberPatternViewModel> = NumberPatternViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentNumberPatternBinding = FragmentNumberPatternBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
