package com.homanad.android.baseproject.domain.usecases

import com.homanad.android.baseproject.domain.base.usecases.BaseUseCaseWithParams
import com.homanad.android.baseproject.domain.entities.MyEntity
import com.homanad.android.baseproject.domain.repositories.MyRepository

class GetSomethingUseCase(
    private val myRepository: MyRepository
) : BaseUseCaseWithParams<Int, MyEntity?>() {

    override suspend fun execute(params: Int): MyEntity? {
        return myRepository.getSomething(params)
    }
}