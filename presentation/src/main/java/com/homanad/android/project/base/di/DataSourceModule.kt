package com.homanad.android.project.base.di

import com.homanad.android.project.data.datasources.local.daos.ModelDao
import com.homanad.android.project.data.datasources.local.daos.ModelDaoImpl
import com.homanad.android.project.data.datasources.remote.services.MyService
import com.homanad.android.project.data.datasources.remote.services.MyServiceImpl

object DataSourceModule {

    fun getLocalDataSource(): ModelDao = ModelDaoImpl()

    fun getRemoteDataSource(): MyService = MyServiceImpl()
}