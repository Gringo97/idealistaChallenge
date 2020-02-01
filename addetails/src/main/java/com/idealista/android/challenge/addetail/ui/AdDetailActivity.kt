package com.idealista.android.challenge.addetail.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idealista.android.challenge.addetail.AdDetailAssembler

const val ADDETAIL = "ADDETAIL"

class AdDetailActivity : AppCompatActivity(), AdDetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //  setContentView(R.layout.activity_list)
        AdDetailAssembler.presenter = AdDetailPresenter(this)
        AdDetailAssembler.presenter.onAdNeeded(intent.extras!!.getString(ADDETAIL)!!)
    }

    override fun render(list: AdDetailModel) {
        print(list)
    }
}
