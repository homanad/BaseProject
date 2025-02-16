package com.homanad.android.project.domain.usecases

import com.homanad.android.project.domain.base.usecases.BaseUseCaseWithParams
import com.homanad.android.project.domain.entities.MyEntity
import com.homanad.android.project.domain.repositories.MyRepository

class GetSomethingUseCase(
    private val myRepository: MyRepository
) : BaseUseCaseWithParams<Int, MyEntity?>() {

    override suspend fun execute(params: Int): MyEntity? {
        return myRepository.getSomething(params)
    }
}