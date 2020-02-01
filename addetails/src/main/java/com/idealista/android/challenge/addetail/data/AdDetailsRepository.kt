package com.idealista.android.challenge.addetail.data

import com.idealista.android.challenge.addetail.domain.AdDetail
import com.idealista.android.challenge.addetail.domain.toDomain
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either

class AdDetailsRepository(private val dataSource: AdDetailsDataSource) {
    fun loadDetails(detailUrl: String): Either<CommonError, AdDetail> =
        dataSource.loadDetails("https://api.myjson.com/bins/1807oe").map { it.toDomain() }
}