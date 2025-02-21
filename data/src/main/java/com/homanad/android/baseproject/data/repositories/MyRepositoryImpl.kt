package com.homanad.android.baseproject.data.repositories

import com.homanad.android.baseproject.data.datasources.local.daos.ModelDao
import com.homanad.android.baseproject.data.datasources.remote.services.MyService
import com.homanad.android.baseproject.data.mappers.toMyEntity
import com.homanad.android.baseproject.domain.entities.MyEntity
import com.homanad.android.baseproject.domain.repositories.MyRepository
import kotlin.random.Random

class MyRepositoryImpl(
    private val modelDao: ModelDao,
    private val myService: MyService
) : MyRepository {

    override suspend fun getSomethings(): List<MyEntity> {
        val network = Random.nextBoolean()
        return if (network) {
            myService.getSomethings().map { it.toMyEntity() }
        } else modelDao.getSomethings().map { it.toMyEntity() }
    }

    override suspend fun getSomething(param: Int): MyEntity? {
        val network = Random.nextBoolean()
        return if (network) {
            myService.getSomething(param)?.toMyEntity()
        } else modelDao.getSomething(param)?.toMyEntity()
    }
}