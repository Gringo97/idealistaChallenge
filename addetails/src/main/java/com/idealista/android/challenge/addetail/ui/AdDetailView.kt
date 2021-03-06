package com.idealista.android.challenge.addetail.ui

interface AdDetailView {
    fun render(adDetail: AdDetailModel)
    fun showError(errorMessage: String)
    fun setFavorite(drawable: Int)
}