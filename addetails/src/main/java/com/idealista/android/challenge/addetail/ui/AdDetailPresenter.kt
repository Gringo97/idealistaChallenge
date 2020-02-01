package com.idealista.android.challenge.addetail.ui

import com.idealista.android.challenge.addetail.AdDetailAssembler
import com.idealista.android.challenge.addetail.domain.AdDetail
import com.idealista.android.challenge.addetail.domain.loadAdDetails
import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.wrench.usecase.UseCase

class AdDetailPresenter(private val view: AdDetailView) {


    fun onAdNeeded(id: String) {
        UseCase<CommonError, AdDetail>()
            .bg(
                loadAdDetails(
                    AdDetailAssembler.adDetailsRepository,
                    "https://api.myjson.com/bins/$id"
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {

                    },
                    {
                        view.render(it)
                    }
                )
            }.run(CoreAssembler.executor)
    }

/*
    fun onAdClicked(ad: AdModel) {
        UseCase<CommonError, AdDetail>()
            .bg(
                loadAdDetails(
                    AdDetailAssembler.adDetailsRepository,
                    "https://api.myjson.com/bins/1807oe"
                )
            )
            .map { it.toModel() }
            .ui {
                it.fold(
                    {

                    },
                    {
                        // view.render(it)

                    }
                )
            }.run(CoreAssembler.executor)
    }

 */
}