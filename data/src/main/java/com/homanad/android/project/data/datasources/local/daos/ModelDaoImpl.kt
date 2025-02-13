package com.homanad.android.project.data.datasources.local.daos

import com.homanad.android.project.data.datasources.local.models.RoomModel

class ModelDaoImpl : ModelDao {
    override fun getSomething(): RoomModel {
        return RoomModel("id", "My", "name", "is 'getSomething from ModelDao'")
    }

    override fun getSomething(param: Int): List<RoomModel> {
        return listOf(
            RoomModel("id", "My", "name", "is 'getSomething from ModelDao 1'"),
            RoomModel("id", "My", "name", "is 'getSomething from ModelDao 2'"),
            RoomModel("id", "My", "name", "is 'getSomething from ModelDao 3'")
        )
    }
}