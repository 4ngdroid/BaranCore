package com.arghamnegargroup.core.features.stock.data.pref

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StockPreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_CURRENT_STOCK = "PREF_KEY_CURRENT_STOCK"
    }

    fun getCurrentStock(): String? = prefs.getString(KEY_CURRENT_STOCK, null)
    fun setCurrentStock(value: String) = prefs.edit().putString(KEY_CURRENT_STOCK, value).apply()
    fun removeCurrentStock() = prefs.edit().remove(KEY_CURRENT_STOCK).apply()

}