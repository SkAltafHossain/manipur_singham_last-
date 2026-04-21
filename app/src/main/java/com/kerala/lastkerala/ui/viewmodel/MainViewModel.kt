package com.altaf.haryanalast.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.altaf.haryanalast.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainData, MainEvent>() {

    val categoryName = MutableLiveData<String>("")
}
