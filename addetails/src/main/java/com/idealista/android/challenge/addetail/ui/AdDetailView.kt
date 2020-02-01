package com.idealista.android.challenge.addetail.ui

import android.graphics.drawable.Drawable

interface AdDetailView {
    fun render(adDetail: AdDetailModel)

    fun setFavorite(drawable: Int)
}