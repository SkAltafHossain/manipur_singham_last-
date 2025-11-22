package com.kerala.lastkerala.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.kerala.lastkerala.R
import com.kerala.lastkerala.common.base.BaseActivity
import com.kerala.lastkerala.databinding.ActivityMainBinding
import com.kerala.lastkerala.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelClass(): Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding.main.post {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
            val navController = navHostFragment?.navController ?: return@post
        }

    }
}