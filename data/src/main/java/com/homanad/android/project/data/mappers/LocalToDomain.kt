package com.homanad.android.project.data.mappers

import com.homanad.android.project.data.local.models.RoomModel
import com.homanad.android.project.data.remote.models.RemoteModel
import com.homanad.android.project.domain.entities.MyEntity

fun RoomModel.toMyEntity() = MyEntity(id, property1, property2, property3)

fun RemoteModel.toMyEntity() = MyEntity(id, property1, property2, property3)