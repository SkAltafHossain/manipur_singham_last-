package com.altaf.manipursingham.ui

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.WindowInsets
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.altaf.manipursingham.R
import com.altaf.manipursingham.common.base.BaseActivity
import com.altaf.manipursingham.common.extension.gone
import com.altaf.manipursingham.common.extension.visible
import com.altaf.manipursingham.databinding.ActivityMainBinding
import com.altaf.manipursingham.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            binding.view.gone()
            binding.view1.gone()
        } else {
            binding.view.visible()
            if(isGestureNavigationEnabled(this)) {
                binding.view1.gone()
            } else {
                binding.view1.visible()
            }
        }

        binding.main.post {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            val navController = navHostFragment?.navController ?: return@post
        }
    }
    fun isGestureNavigationEnabled(context: Context): Boolean {
        val resources = context.resources
        val resourceId = resources.getIdentifier("config_navBarInteractionMode", "integer", "android")
        return if (resourceId > 0) {
            resources.getInteger(resourceId) == 2 // 2 = Gesture Navigation
        } else {
            false
        }
    }

}