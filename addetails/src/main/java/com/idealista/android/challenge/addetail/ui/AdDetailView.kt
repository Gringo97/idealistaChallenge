package com.idealista.android.challenge.addetail.ui

interface AdDetailView {
    fun render(adDetail: AdDetailModel)

    fun setFavorite(drawable: Int)
}