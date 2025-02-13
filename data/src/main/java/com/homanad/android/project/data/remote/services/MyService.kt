package com.homanad.android.project.data.remote.services

import com.homanad.android.project.data.local.models.RoomModel

interface MyService {
    fun getSomething(): RoomModel
    fun getSomething(param: Int): List<RoomModel>
}