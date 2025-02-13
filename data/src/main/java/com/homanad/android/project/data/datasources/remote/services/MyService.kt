package com.homanad.android.project.data.datasources.remote.services

import com.homanad.android.project.data.datasources.remote.models.RemoteModel

interface MyService {
    fun getSomething(): RemoteModel
    fun getSomething(param: Int): List<RemoteModel>
}