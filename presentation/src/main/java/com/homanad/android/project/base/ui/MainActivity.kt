package com.homanad.android.project.base.ui

import androidx.lifecycle.ViewModelProvider
import com.homanad.android.project.base.R
import com.homanad.android.project.base.common.BaseBindingActivity
import com.homanad.android.project.base.databinding.ActivityMainBinding
import com.homanad.android.project.base.ui.vm.MainViewModel
import com.homanad.android.project.base.ui.vm.MainViewModelFactory

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun getContentRes() = R.layout.activity_main

    override val isEdgeToEdge = true

    private val mainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }
}