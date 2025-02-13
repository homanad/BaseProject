package com.homanad.android.project.data.repositories

import com.homanad.android.project.data.local.daos.ModelDao
import com.homanad.android.project.data.mappers.toMyEntity
import com.homanad.android.project.data.remote.services.MyService
import com.homanad.android.project.domain.entities.MyEntity
import com.homanad.android.project.domain.repositories.MyRepository
import kotlin.random.Random

class MyRepositoryImpl(
    private val modelDao: ModelDao,
    private val myService: MyService
) : MyRepository {

    override suspend fun getSomething(): MyEntity {
        val network = Random.nextBoolean()
        return if (network) {
            myService.getSomething().toMyEntity()
        } else modelDao.getSomething().toMyEntity()
    }

    override suspend fun getSomething(param: Int): List<MyEntity> {
        val network = Random.nextBoolean()
        return if (network) {
            myService.getSomething(param).map { it.toMyEntity() }
        } else modelDao.getSomething(param).map { it.toMyEntity() }
    }
}