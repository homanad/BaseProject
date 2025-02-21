package com.homanad.android.baseproject.domain.repositories

import com.homanad.android.baseproject.domain.entities.MyEntity

interface MyRepository {
    suspend fun getSomethings(): List<MyEntity>
    suspend fun getSomething(param: Int): MyEntity?
}