package com.idealista.android.challenge.list.ui

import com.idealista.android.challenge.core.CoreAssembler
import com.idealista.android.challenge.core.api.model.CommonError
import com.idealista.android.challenge.core.api.model.string
import com.idealista.android.challenge.core.wrench.usecase.UseCase
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.domain.List
import com.idealista.android.challenge.list.domain.list

class ListPresenter(private val view: ListView) {

    fun onListNeeded() {
        UseCase<CommonError, List>()
            .bg(list(ListAssembler.listRepository))
            .map { it.toModel() }
            .ui {
                it.fold(
                    { commonError ->
                        view.showError(commonError.string())
                    },
                    { listModel ->
                        view.render(listModel)
                    }
                )
            }.run(CoreAssembler.executor)
    }

    fun onAdClicked(ad: AdModel) {
        view.navigateToAdDetail(ad)
    }

}