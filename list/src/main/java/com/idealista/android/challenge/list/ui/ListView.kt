package com.idealista.android.challenge.list.ui

interface ListView {
    fun render(list: ListModel)
    fun navigateToAdDetail(adModel: AdModel)
}