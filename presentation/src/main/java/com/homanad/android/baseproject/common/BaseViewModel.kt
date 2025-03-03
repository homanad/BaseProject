package com.homanad.android.baseproject.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean

abstract class BaseViewModel<Intent, State>(
    configs: ViewModelConfigs = ViewModelConfigs()
) : ViewModel() {

    private val initialised = AtomicBoolean(false)

    private val _intentChannel = Channel<Intent>(configs.intentChannelSize)

    private val _stateChannel = Channel<State>(configs.stateChannelSize)

    val stateFlow: Flow<State> = _stateChannel.receiveAsFlow()

    init {
        start()
    }

    private fun start() {
        if (initialised.compareAndSet(false, true)) {
            onFirstStart()
            viewModelScope.launch(Dispatchers.IO) {
                for (intent in _intentChannel) {
                    launch {
                        processIntent(intent)
                    }
                }
            }
        }
    }

    protected open fun onFirstStart() {}

    protected abstract suspend fun processIntent(intent: Intent)

    fun sendIntent(intent: Intent) {
        viewModelScope.launch {
            _intentChannel.send(intent)
        }
    }

    protected fun emitState(state: State) {
        viewModelScope.launch {
            _stateChannel.send(state)
        }
    }
}

data class ViewModelConfigs(
    val intentChannelSize: Int = Channel.UNLIMITED,
    val stateChannelSize: Int = Channel.BUFFERED,
)