package com.idealista.android.challenge.addetail.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.addetail.AdDetailAssembler
import com.idealista.android.challenge.addetail.R
import kotlinx.android.synthetic.main.ad_detail_activity.*

const val ADDETAIL = "ADDETAIL"

class AdDetailActivity : AppCompatActivity(), AdDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_detail_activity)
        AdDetailAssembler.presenter = AdDetailPresenter(this)
        AdDetailAssembler.presenter.onAdNeeded(intent.extras!!.getString(ADDETAIL)!!)
    }

    override fun render(adDetail: AdDetailModel) {
        title_tv.text = adDetail.title
        extended_property_tv.apply {
            if (adDetail.extendedPropertyType.isNotEmpty()) {
                text = adDetail.extendedPropertyType
            } else {
                visibility = View.GONE
            }
        }
        view_pager.apply {
            adapter = AdDetailMultimediaAdapter(context, adDetail.thumbnailsList)
        }
        price_tv.text = adDetail.price
        comments_tv.text = adDetail.propertyComment
    }
}
