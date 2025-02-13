package com.homanad.android.project.domain.base.usecases

abstract class DefaultUseCaseWithParams<in Params, out ReturnType> {

    protected abstract suspend fun execute(params: Params)

    suspend operator fun invoke(params: Params) = execute(params)
}