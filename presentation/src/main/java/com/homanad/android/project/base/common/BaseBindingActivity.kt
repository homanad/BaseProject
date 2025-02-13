package com.homanad.android.project.base.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<B : ViewDataBinding> : AppCompatActivity() {

    private lateinit var _binding: B

    protected val binding = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, getContentRes())
        restoreInstanceState(savedInstanceState)
        setupUI()
        handleUIEvent()
        handleUIState()
    }

    @LayoutRes
    protected abstract fun getContentRes(): Int

    protected open fun restoreInstanceState(instanceState: Bundle?) {}

    protected open fun setupUI() {}

    protected open fun handleUIEvent() {}

    protected open fun handleUIState() {}
}