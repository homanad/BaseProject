package com.homanad.android.project.data.mappers

import com.homanad.android.project.data.datasources.remote.models.RemoteModel
import com.homanad.android.project.domain.entities.MyEntity

fun RemoteModel.toMyEntity() = MyEntity(id, property1, property2, property3)