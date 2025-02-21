package com.homanad.android.baseproject.data.datasources.remote.services

import com.homanad.android.baseproject.data.datasources.remote.models.RemoteModel

interface MyService {
    fun getSomethings(): List<RemoteModel>
    fun getSomething(param: Int): RemoteModel?
}