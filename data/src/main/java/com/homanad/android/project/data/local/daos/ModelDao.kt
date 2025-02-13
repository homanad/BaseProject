package com.homanad.android.project.data.local.daos

import com.homanad.android.project.data.local.models.RoomModel

abstract class ModelDao {
    abstract fun getSomething(): RoomModel
    abstract fun getSomething(param: Int): List<RoomModel>
}