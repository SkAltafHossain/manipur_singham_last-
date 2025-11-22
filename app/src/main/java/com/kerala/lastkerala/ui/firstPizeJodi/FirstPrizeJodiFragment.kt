package com.kerala.lastkerala.ui.firstPizeJodi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kerala.lastkerala.common.base.BaseFragment
import com.kerala.lastkerala.databinding.FragmentFirstPrizeJodiBinding
import com.kerala.lastkerala.ui.firstPizeJodi.viewmodel.FirstPrizeJodiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstPrizeJodiFragment : BaseFragment<FirstPrizeJodiViewModel, FragmentFirstPrizeJodiBinding>() {
    override fun getViewModelClass(): Class<FirstPrizeJodiViewModel> = FirstPrizeJodiViewModel::class.java

    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentFirstPrizeJodiBinding = 
        FragmentFirstPrizeJodiBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearEvent()
    }
}