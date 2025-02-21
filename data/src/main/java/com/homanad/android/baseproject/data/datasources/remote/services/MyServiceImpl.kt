package com.homanad.android.baseproject.data.datasources.remote.services

import com.homanad.android.baseproject.data.datasources.remote.models.RemoteModel

class MyServiceImpl : MyService {

    override fun getSomething(param: Int): RemoteModel? {
        return dummyRemote.find { it.id == param }
    }

    override fun getSomethings(): List<RemoteModel> {
        return dummyRemote
    }
}

val dummyRemote = listOf(
    RemoteModel(1, "My", "name", "is 'getSomething from MyService 1'"),
    RemoteModel(2, "My", "name", "is 'getSomething from MyService 2'"),
    RemoteModel(3, "My", "name", "is 'getSomething from MyService 3'")
)