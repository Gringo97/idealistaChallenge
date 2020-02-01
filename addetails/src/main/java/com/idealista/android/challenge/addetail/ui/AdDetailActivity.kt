package com.idealista.android.challenge.addetail.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.addetail.AdDetailAssembler
import com.idealista.android.challenge.addetail.R

const val ADDETAIL = "ADDETAIL"

class AdDetailActivity : AppCompatActivity(), AdDetailView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ad_detail_activity)
        AdDetailAssembler.presenter = AdDetailPresenter(this)
        AdDetailAssembler.presenter.onAdNeeded(intent.extras!!.getString(ADDETAIL)!!)
    }

    override fun render(adDetail: AdDetailModel) {
        findViewById<TextView>(R.id.title_tv).apply {
            text = adDetail.title
        }
        findViewById<TextView>(R.id.extended_property_tv).apply {
            if (adDetail.extendedPropertyType.isNotEmpty()) {
                text = adDetail.extendedPropertyType
            } else {
                visibility = View.GONE
            }
        }
        findViewById<TextView>(R.id.price_tv).apply {
            text = adDetail.price
        }
        findViewById<TextView>(R.id.comments_tv).apply {
            text = adDetail.propertyComment
        }

    }
}
