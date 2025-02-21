package com.homanad.android.baseproject.data.mappers

import com.homanad.android.baseproject.data.datasources.local.models.RoomModel
import com.homanad.android.baseproject.domain.entities.MyEntity

fun RoomModel.toMyEntity() = MyEntity(id, property1, property2, property3)