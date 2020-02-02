package com.idealista.android.challenge.addetail.ui

import com.idealista.android.challenge.addetail.AdDetailAssembler
import com.idealista.android.challenge.addetail.R
import com.idealista.android.challenge.addetail.domain.AdDetail
import com.idealista.android.challenge.addetail.domain.loadAdDetails
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.api.model.string
import com.idealista.android.challenge.core.wrench.usecase.UseCase

class AdDetailPresenter(private val view: AdDetailView) {

    fun onAdNeeded(urlDetail: String) {
        UseCase<CommonError, AdDetail>()
            .bg(
                loadAdDetails(
                    AdDetailAssembler.adDetailsRepository,
                    urlDetail
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {commonError ->
                        view.showError(commonError.string())
                    },
                    { adDetailModel ->
                        view.render(adDetailModel)
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun setAdFavorite(adId: Int) {
        when (AdDetailAssembler.preferences.getAd(adId)) {
            null -> {
                AdDetailAssembler.preferences.adAd(adId)
                view.setFavorite(R.drawable.ic_like)
            }
            else -> {
                AdDetailAssembler.preferences.removeAd(adId)
                view.setFavorite(R.drawable.ic_like_unused)
            }
        }
    }

}