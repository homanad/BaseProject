package com.homanad.android.project.data.datasources.remote.services

import com.homanad.android.project.data.datasources.remote.models.RemoteModel

class MyServiceImpl : MyService {

    override fun getSomething(): RemoteModel {
        return RemoteModel("id", "My", "name", "is 'getSomething from MyService'")
    }

    override fun getSomething(param: Int): List<RemoteModel> {
        return listOf(
            RemoteModel("id", "My", "name", "is 'getSomething from MyService 1'"),
            RemoteModel("id", "My", "name", "is 'getSomething from MyService 2'"),
            RemoteModel("id", "My", "name", "is 'getSomething from MyService 3'")
        )
    }
}