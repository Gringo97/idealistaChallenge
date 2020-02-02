package com.idealista.android.challenge.core.api

import com.idealista.android.challenge.core.model.entity.AdDetailEntity
import com.idealista.android.challenge.core.model.entity.ListEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface ApiService {

    @GET("/bins/93tqm")
    fun list(): Call<ListEntity>


    @GET
    fun loadDetails(@Url detailUrl: String): Call<AdDetailEntity>


}