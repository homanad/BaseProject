package com.homanad.android.project.base.di

import com.homanad.android.project.data.repositories.MyRepositoryImpl
import com.homanad.android.project.domain.repositories.MyRepository

object RepositoryModule {

    fun getMyRepository(): MyRepository = MyRepositoryImpl(
        DataSourceModule.getLocalDataSource(),
        DataSourceModule.getRemoteDataSource()
    )
}