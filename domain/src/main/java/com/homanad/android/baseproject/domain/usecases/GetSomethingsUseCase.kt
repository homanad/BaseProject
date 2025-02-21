package com.homanad.android.baseproject.domain.usecases

import com.homanad.android.baseproject.domain.base.usecases.BaseUseCase
import com.homanad.android.baseproject.domain.entities.MyEntity
import com.homanad.android.baseproject.domain.repositories.MyRepository

class GetSomethingsUseCase(
    private val myRepository: MyRepository
) : BaseUseCase<List<MyEntity>>() {

    override suspend fun execute(): List<MyEntity> {
        return myRepository.getSomethings()
    }
}