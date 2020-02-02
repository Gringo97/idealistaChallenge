package com.idealista.android.challenge.addetail.data

import com.idealista.android.challenge.core.api.AdDetailsApi
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.wrench.type.Either

class AdDetailsDataSource(private val api: AdDetailsApi) {

    fun loadDetails(detailUrl: String): Either<CommonError, AdDetailEntity> =

        api.loadDetails(detailUrl)

}