package com.homanad.android.project.base.di

import com.homanad.android.project.domain.usecases.GetSomethingUseCase
import com.homanad.android.project.domain.usecases.GetSomethingsUseCase

object UseCaseModule {

    fun getGetSomethingUseCase() = GetSomethingUseCase(RepositoryModule.getMyRepository())

    fun getGetSomethingsUseCase() = GetSomethingsUseCase(RepositoryModule.getMyRepository())
}