package com.homanad.android.project.data.mappers

import com.homanad.android.project.data.datasources.local.models.RoomModel
import com.homanad.android.project.domain.entities.MyEntity

fun RoomModel.toMyEntity() = MyEntity(id, property1, property2, property3)