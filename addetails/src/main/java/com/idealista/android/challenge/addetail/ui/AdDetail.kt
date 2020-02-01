package com.idealista.android.challenge.addetail.ui

import com.idealista.android.challenge.addetail.AdDetailAssembler
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
    val propertyComment: String,
    val drawableFavorite: Int
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
        propertyComment,
        setAdFavoriteDrawable(adid)

    )


private fun formatPrice(price: Double) = "$price €"
private fun formatTitle(typology: Typology, operation: Operation) =
    CoreAssembler.stringsProvider.string(
        R.string.typology_at_operation,
        typology.string().capitalize(),
        operation.string().toLowerCase()
    )


fun setAdFavoriteDrawable(id: Int): Int {
    return when (AdDetailAssembler.preferences.getAd(id)) {
        null -> {
            R.drawable.ic_like_unused
        }
        else -> {
            R.drawable.ic_like
        }
    }
}
