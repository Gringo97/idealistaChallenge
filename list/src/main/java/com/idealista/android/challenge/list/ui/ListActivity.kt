package com.idealista.android.challenge.list.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idealista.android.challenge.addetail.ui.ADDETAIL
import com.idealista.android.challenge.addetail.ui.AdDetailActivity
import com.idealista.android.challenge.list.ListAssembler
import com.idealista.android.challenge.list.R

class ListActivity : AppCompatActivity(), ListView {

    private lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        ListAssembler.presenter = ListPresenter(this)
        listAdapter = ListAdapter()
        findViewById<RecyclerView>(R.id.recycler).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = listAdapter
        }
        ListAssembler.presenter.onListNeeded()
    }

    override fun render(list: ListModel) {
        listAdapter.set(list)
        listAdapter.listener(object : ListAdapter.AdListener {
            override fun onAdClicked(ad: AdModel) {
                ListAssembler.presenter.onAdClicked(ad)
            }
        })
    }

    override fun navigateToAdDetail(adModel: AdModel) {
        val intent = Intent(baseContext, AdDetailActivity::class.java)
        intent.putExtra(ADDETAIL, adModel.id)
        startActivity(intent)
    }
}