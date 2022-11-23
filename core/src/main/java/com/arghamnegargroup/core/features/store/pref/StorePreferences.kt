package com.arghamnegargroup.core.features.store.pref

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StorePreferences @Inject constructor(private val prefs: SharedPreferences) {

    companion object {
        const val KEY_CURRENT_STORE = "PREF_KEY_CURRENT_STORE"
    }

    fun getCurrentStore(): String? = prefs.getString(KEY_CURRENT_STORE, null)
    fun setCurrentStore(value: String) = prefs.edit().putString(KEY_CURRENT_STORE, value).apply()
    fun removeCurrentStore() = prefs.edit().remove(KEY_CURRENT_STORE).apply()
}