package com.idealista.android.challenge.addetail.ui

import android.os.Bundle
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
        AdDetailAssembler.presenter.onAdNeeded(intent.extras.getString(ADDETAIL))
        AdDetailAssembler.preferences.init(baseContext)

    }

    override fun render(adDetail: AdDetailModel) {
        title_tv.text = adDetail.title
        view_pager.apply {
            adapter = AdDetailMultimediaAdapter(context, adDetail.thumbnailsList)
        }
        btn_favorite.apply {
            setOnClickListener {
                AdDetailAssembler.presenter.setAdFavorite(adDetail.adid)
            }
        }
        btn_favorite.setImageDrawable(resources.getDrawable(adDetail.drawableFavorite, null))
        price_tv.text = adDetail.price
        comments_tv.text = adDetail.propertyComment
    }

    override fun setFavorite(drawable: Int) {
        btn_favorite.setImageDrawable(resources.getDrawable(drawable, null))
    }


}

