package com.idealista.android.challenge.addetail.domain

import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.MultimediasEntity

data class AdDetail (
    val adid: Int,
    val extendedPropertyType: String,
    val multimedia: MultimediasEntity,
    val operation: String,
    val price: Double,
    val propertyComment: String,
    val propertyType: String
)

fun AdDetailEntity.toDomain() = AdDetail(
    adid,
    extendedPropertyType,
    multimedia,
    operation,
    price,
    propertyComment,
    propertyType



)