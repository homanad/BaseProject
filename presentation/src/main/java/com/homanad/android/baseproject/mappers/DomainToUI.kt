package com.homanad.android.baseproject.mappers

import com.homanad.android.baseproject.models.MyModel
import com.homanad.android.baseproject.domain.entities.MyEntity

fun MyEntity.toMyModel() = MyModel(id, "$property1 $property2 $property3")