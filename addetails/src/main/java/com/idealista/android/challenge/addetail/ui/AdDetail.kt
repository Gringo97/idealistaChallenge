package com.idealista.android.challenge.addetail.ui

import com.idealista.android.challenge.addetail.domain.AdDetail
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.R
import com.idealista.android.challenge.core.model.Operation
import com.idealista.android.challenge.core.model.Typology
import com.idealista.android.challenge.core.model.string

data class AdDetailModel(
    val adid: Int,
    val title: String,
    val thumbnailsList: List<String>?,
    val price: String,
    val propertyComment: String
)


fun AdDetail.toModel() =
    AdDetailModel(
        adid,
        if (typology.string().isEmpty()) {
            formatTitle(extendedPropertyType, operation)
        } else {
            formatTitle(typology, operation)
        },
        thumbnailsList,
        formatPrice(price),
        propertyComment

    )


private fun formatPrice(price: Double) = "$price €"
private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string().capitalize(),
        operation.string().toLowerCase()
    )
