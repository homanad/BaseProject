package com.homanad.android.baseproject.di

import com.homanad.android.baseproject.data.datasources.local.daos.ModelDao
import com.homanad.android.baseproject.data.datasources.local.daos.ModelDaoImpl
import com.homanad.android.baseproject.data.datasources.remote.services.MyService
import com.homanad.android.baseproject.data.datasources.remote.services.MyServiceImpl

object DataSourceModule {

    fun getLocalDataSource(): ModelDao = ModelDaoImpl()

    fun getRemoteDataSource(): MyService = MyServiceImpl()
}