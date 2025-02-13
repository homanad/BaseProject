package com.homanad.android.project.domain.usecases

import com.homanad.android.project.domain.base.usecases.BaseUseCase
import com.homanad.android.project.domain.entities.MyEntity
import com.homanad.android.project.domain.repositories.MyRepository

class GetSomethingUseCase(
    private val myRepository: MyRepository
) : BaseUseCase<MyEntity>() {

    override suspend fun execute(): MyEntity {
        return myRepository.getSomething()
    }
}