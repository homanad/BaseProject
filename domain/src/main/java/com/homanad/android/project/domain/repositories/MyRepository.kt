package com.homanad.android.project.domain.repositories

import com.homanad.android.project.domain.entities.MyEntity

interface MyRepository {
    suspend fun getSomethings(): List<MyEntity>
    suspend fun getSomething(param: Int): MyEntity?
}