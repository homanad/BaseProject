package com.homanad.android.baseproject.di

import com.homanad.android.baseproject.data.repositories.MyRepositoryImpl
import com.homanad.android.baseproject.domain.repositories.MyRepository

object RepositoryModule {

    fun getMyRepository(): MyRepository = MyRepositoryImpl(
        DataSourceModule.getLocalDataSource(),
        DataSourceModule.getRemoteDataSource()
    )
}