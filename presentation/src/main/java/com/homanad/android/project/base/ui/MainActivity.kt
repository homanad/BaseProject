package com.homanad.android.project.base.ui

import com.homanad.android.project.base.R
import com.homanad.android.project.base.common.BaseBindingActivity
import com.homanad.android.project.base.databinding.ActivityMainBinding

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun getContentRes() = R.layout.activity_main

    override val isEdgeToEdge = true
}