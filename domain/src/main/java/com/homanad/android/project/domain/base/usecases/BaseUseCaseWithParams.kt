package com.homanad.android.project.domain.base.usecases

abstract class BaseUseCaseWithParams<in Params, out ReturnType> {

    protected abstract suspend fun execute(params: Params): ReturnType

    suspend operator fun invoke(params: Params) = execute(params)
}