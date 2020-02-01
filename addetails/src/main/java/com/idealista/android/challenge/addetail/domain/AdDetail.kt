package com.idealista.android.challenge.addetail.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.MultimediasEntity

data class AdDetail(
    val adid: Int,
    val extendedPropertyType: String,
    val multimedia: MultimediasEntity,
    val operation: Operation,
    val price: Double,
    val propertyComment: String,
    val typology: Typology
)

fun AdDetailEntity.toDomain() = AdDetail(
    adid,
    extendedPropertyType,
    multimedia,
    Operation.from(operation),
    price,
    propertyComment,
    Typology.from(propertyType)


)