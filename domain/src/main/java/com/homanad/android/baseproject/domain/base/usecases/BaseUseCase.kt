package com.homanad.android.baseproject.domain.base.usecases

abstract class BaseUseCase<out ReturnType> {

    protected abstract suspend fun execute(): ReturnType

    suspend operator fun invoke() = execute()
}