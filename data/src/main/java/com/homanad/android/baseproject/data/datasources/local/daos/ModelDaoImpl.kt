package com.homanad.android.baseproject.data.datasources.local.daos

import com.homanad.android.baseproject.data.datasources.local.models.RoomModel

class ModelDaoImpl : ModelDao {
    override fun getSomething(param: Int): RoomModel? {
        return dummyLocal.find { param == it.id }
    }

    override fun getSomethings(): List<RoomModel> {
        return dummyLocal
    }
}

val dummyLocal = listOf(
    RoomModel(1, "My", "name", "is 'getSomething from ModelDao 1'"),
    RoomModel(2, "My", "name", "is 'getSomething from ModelDao 2'"),
    RoomModel(3, "My", "name", "is 'getSomething from ModelDao 3'")
)