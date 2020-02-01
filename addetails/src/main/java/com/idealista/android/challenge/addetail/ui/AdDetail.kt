package com.idealista.android.challenge.addetail.ui

import com.idealista.android.challenge.addetail.domain.AdDetail
import com.idealista.android.challenge.core.model.entity.MultimediasEntity

data class AdDetailModel(
    val adid: Int,
    val extendedPropertyType: String,
    val multimedia: MultimediasEntity,
    val operation: String,
    val price: Double,
    val propertyComment: String,
    val propertyType: String
)


//TODO TEMPORAL MODEL WITH ALL DATA
fun AdDetail.toModel() =
    AdDetailModel(
        adid,
        extendedPropertyType,
        multimedia,
        operation,
        price,
        propertyComment,
        propertyType
    )
