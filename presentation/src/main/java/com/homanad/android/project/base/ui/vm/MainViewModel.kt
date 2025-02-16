package com.homanad.android.project.base.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.homanad.android.project.base.common.BaseViewModel
import com.homanad.android.project.base.di.UseCaseModule
import com.homanad.android.project.base.mappers.toMyModel
import com.homanad.android.project.base.models.MyModel
import com.homanad.android.project.domain.usecases.GetSomethingUseCase
import com.homanad.android.project.domain.usecases.GetSomethingsUseCase

class MainViewModel(
    private val getSomethingUseCase: GetSomethingUseCase,
    private val getSomethingsUseCase: GetSomethingsUseCase
) : BaseViewModel<MainViewModel.Intent, MainViewModel.State>() {

    sealed interface Intent {
        data object GetSomethingsIntent : Intent
        data class GetSomethingIntent(val id: Int) : Intent
    }

    sealed interface State {
        data class SomethingData(val myModel: MyModel?) : State
        data class SomethingsData(val myModels: List<MyModel>) : State
    }

    override suspend fun processIntent(intent: Intent) {
        when (intent) {
            is Intent.GetSomethingIntent -> getSomething(intent.id)
            Intent.GetSomethingsIntent -> getSomethings()
        }
    }

    private suspend fun getSomething(id: Int) {
        emitState(State.SomethingData(getSomethingUseCase(id)?.toMyModel()))
    }

    private suspend fun getSomethings() {
        emitState(State.SomethingsData(getSomethingsUseCase().map { it.toMyModel() }))
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                UseCaseModule.getGetSomethingUseCase(),
                UseCaseModule.getGetSomethingsUseCase()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
