package com.idealista.android.challenge.core.model.entity

data class AdDetailEntity(
    val adid: Int,
    val extendedPropertyType: String,
    val multimedia: MultimediasEntity,
    val operation: String,
    val price: Double,
    val propertyComment: String,
    val propertyType: String
)