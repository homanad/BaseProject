package com.homanad.android.baseproject.data.datasources.local.daos

import com.homanad.android.baseproject.data.datasources.local.models.RoomModel

interface ModelDao {
    fun getSomething(param: Int): RoomModel?
    fun getSomethings(): List<RoomModel>
}