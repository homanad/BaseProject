package com.homanad.android.project.domain.base.usecases

abstract class DefaultUseCase<out ReturnType> {

    protected abstract suspend fun execute()

    suspend operator fun invoke() = execute()
}