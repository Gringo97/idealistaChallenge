package com.idealista.android.challenge.addetail.domain

import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.entity.AdDetailEntity

data class AdDetail(
    val adid: Int,
    val extendedPropertyType: Typology,
    val thumbnailsList: List<String>?,
    val operation: Operation,
    val price: Double,
    val propertyComment: String,
    val typology: Typology
)

fun AdDetailEntity.toDomain() = AdDetail(
    adid,
    Typology.from(extendedPropertyType),
    multimedia.images?.map {
        it.url
    },
    Operation.from(operation),
    price,
    propertyComment,
    Typology.from(propertyType)


)