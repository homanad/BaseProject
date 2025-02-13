package com.homanad.android.project.base.mappers

import com.homanad.android.project.base.models.MyModel
import com.homanad.android.project.domain.entities.MyEntity

fun MyEntity.toMyModel() = MyModel(id, "$property1 $property2 $property3")