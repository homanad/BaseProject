package com.homanad.android.project.domain.usecases

import com.homanad.android.project.domain.base.usecases.BaseUseCase
import com.homanad.android.project.domain.entities.MyEntity
import com.homanad.android.project.domain.repositories.MyRepository

class GetSomethingsUseCase(
    private val myRepository: MyRepository
) : BaseUseCase<List<MyEntity>>() {

    override suspend fun execute(): List<MyEntity> {
        return myRepository.getSomethings()
    }
}