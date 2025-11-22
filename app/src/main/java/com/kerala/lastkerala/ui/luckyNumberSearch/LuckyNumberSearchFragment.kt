package com.kerala.lastkerala.ui.luckyNumberSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentLuckyNumberSearchBinding
import com.kerala.lastkerala.ui.luckyNumberSearch.viewmodel.LuckyNumberSearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LuckyNumberSearchFragment : BaseFragment<LuckyNumberSearchViewModel, FragmentLuckyNumberSearchBinding>() {
    
    override fun getViewModelClass(): Class<LuckyNumberSearchViewModel> = 
        LuckyNumberSearchViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentLuckyNumberSearchBinding = 
        FragmentLuckyNumberSearchBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}