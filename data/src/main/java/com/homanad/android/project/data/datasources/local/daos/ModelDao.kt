package com.homanad.android.project.data.datasources.local.daos

import com.homanad.android.project.data.datasources.local.models.RoomModel

interface ModelDao {
    fun getSomething(): RoomModel
    fun getSomething(param: Int): List<RoomModel>
}