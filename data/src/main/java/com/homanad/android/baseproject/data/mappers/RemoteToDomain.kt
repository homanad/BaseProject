package com.homanad.android.baseproject.data.mappers

import com.homanad.android.baseproject.data.datasources.remote.models.RemoteModel
import com.homanad.android.baseproject.domain.entities.MyEntity

fun RemoteModel.toMyEntity() = MyEntity(id, property1, property2, property3)