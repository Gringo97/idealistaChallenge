package com.idealista.android.challenge.appPrefs

import android.content.Context
import android.content.SharedPreferences


object AppPrefs {
    lateinit var sharedPreferences: SharedPreferences
    private const val PREF_FILE = "prefs"
    private const val AD_ID = "AD_ID_"
    fun init(context: Context) {
        sharedPreferences =
            context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)
    }

    fun getAd(id: Int): String? {
        return sharedPreferences.getString("$AD_ID$id", null)
    }

    fun adAd(id: Int) {
        sharedPreferences.edit().putString("$AD_ID$id", "1").apply()
    }

    fun removeAd(id: Int) {
        sharedPreferences.edit().remove("$AD_ID$id").apply()
    }


}