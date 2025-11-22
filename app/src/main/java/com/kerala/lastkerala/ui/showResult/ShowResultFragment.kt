package com.kerala.lastkerala.ui.showResult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kerala.lastkerala.R
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentShowResultBinding
import com.kerala.lastkerala.ui.showResult.viewmodel.ShowResultViewModel

class ShowResultFragment : BaseFragment<ShowResultViewModel, FragmentShowResultBinding>() {
    
    override fun getViewModelClass(): Class<ShowResultViewModel> = ShowResultViewModel::class.java

    override fun getViewBinding(
        inflater: LayoutInflater, 
        container: ViewGroup?
    ): FragmentShowResultBinding = FragmentShowResultBinding.inflate(inflater, container, false)
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Add any additional setup here
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}
