package com.idealista.android.challenge.addetail

import com.idealista.android.challenge.addetail.data.AdDetailsDataSource
import com.idealista.android.challenge.addetail.data.AdDetailsRepository
import com.idealista.android.challenge.appPrefs.AppPrefs
import com.idealista.android.challenge.addetail.ui.AdDetailPresenter
import com.idealista.android.challenge.core.CoreAssembler

object AdDetailAssembler {
    private val listDataSource: AdDetailsDataSource by lazy { AdDetailsDataSource(CoreAssembler.adDetailsApi) }
    var preferences  = AppPrefs
    lateinit var presenter: AdDetailPresenter
    val adDetailsRepository: AdDetailsRepository by lazy { AdDetailsRepository(listDataSource) }
}
