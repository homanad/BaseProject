package com.homanad.android.baseproject.di

import com.homanad.android.baseproject.domain.usecases.GetSomethingUseCase
import com.homanad.android.baseproject.domain.usecases.GetSomethingsUseCase

object UseCaseModule {

    fun getGetSomethingUseCase() = GetSomethingUseCase(RepositoryModule.getMyRepository())

    fun getGetSomethingsUseCase() = GetSomethingsUseCase(RepositoryModule.getMyRepository())
}