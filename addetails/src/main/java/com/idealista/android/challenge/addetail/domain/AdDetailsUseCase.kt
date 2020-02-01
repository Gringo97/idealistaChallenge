package com.idealista.android.challenge.addetail.domain

import com.idealista.android.challenge.addetail.data.AdDetailsRepository
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.type.Either


fun loadAdDetails(repository: AdDetailsRepository, detailUrl: String): () -> Either<CommonError, AdDetail> =
    {
        repository.loadDetails(detailUrl)
    }