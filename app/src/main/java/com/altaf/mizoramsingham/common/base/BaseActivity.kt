package com.altaf.manipursingham.common.base

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: DB

    /** Must return your layout resource ID */
    protected abstract fun getLayoutId(): Int

    /** Must return your ViewModel class */
    protected abstract fun getViewModelClass(): Class<VM>
    protected open fun setupUI() {}
    protected open fun setupObservers() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val nightModeFlags = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        val isDarkMode = nightModeFlags == Configuration.UI_MODE_NIGHT_YES

        val insetsController = WindowCompat.getInsetsController(window, window.decorView)

        insetsController.isAppearanceLightNavigationBars = !isDarkMode
        // Inflate and bind layout
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[getViewModelClass()]

        setupUI()
        setupObservers()
    }
}
