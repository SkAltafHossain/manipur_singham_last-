package com.kerala.lastkerala.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.kerala.lastkerala.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainData, MainEvent>() {

    val categoryName = MutableLiveData<String>("")
}
