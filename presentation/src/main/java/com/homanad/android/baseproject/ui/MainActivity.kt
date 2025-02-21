package com.homanad.android.baseproject.ui

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.homanad.android.baseproject.R
import com.homanad.android.baseproject.common.BaseBindingActivity
import com.homanad.android.baseproject.databinding.ActivityMainBinding
import com.homanad.android.baseproject.ui.vm.MainViewModel
import com.homanad.android.baseproject.ui.vm.MainViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : BaseBindingActivity<ActivityMainBinding>() {

    override fun getContentRes() = R.layout.activity_main

    override val isEdgeToEdge = true

    private val mainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory())[MainViewModel::class.java]
    }

    override fun handleUIEvent() {
        with(binding) {
            buttonForSomething.setOnClickListener {
                mainViewModel.sendIntent(
                    MainViewModel.Intent.GetSomethingIntent(
                        edtId.text?.toString()?.toInt() ?: 1
                    )
                )
            }

            buttonForSomethings.setOnClickListener {
                mainViewModel.sendIntent(MainViewModel.Intent.GetSomethingsIntent)
            }
        }
    }

    override fun handleUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                launch {
                    mainViewModel.stateFlow.collect {
                        handleState(it)
                    }
                }
            }
        }
    }

    private fun handleState(state: MainViewModel.State) {
        when (state) {
            is MainViewModel.State.SomethingData -> {
                binding.textForSomething.text = state.myModel?.name ?: "Nothing"
            }

            is MainViewModel.State.SomethingsData -> {
                binding.textForSomethings.text =
                    state.myModels.joinToString("\n") { model -> model.name }
            }
        }
    }
}