package com.kerala.lastkerala.ui.firstPrizeFirst

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentFirstPrizeFirstBinding
import com.kerala.lastkerala.databinding.FragmentHomeBinding
import com.kerala.lastkerala.ui.firstPrizeFirst.viewmodel.FirstPrizeFirstViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstPrizeFirstFragment : BaseFragment<FirstPrizeFirstViewModel, FragmentFirstPrizeFirstBinding>() {
    
    override fun getViewModelClass(): Class<FirstPrizeFirstViewModel> = 
        FirstPrizeFirstViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentFirstPrizeFirstBinding = FragmentFirstPrizeFirstBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
