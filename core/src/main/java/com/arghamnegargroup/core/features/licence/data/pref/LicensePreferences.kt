package com.arghamnegargroup.core.features.licence.data.pref

import android.content.SharedPreferences
import com.arghamnegargroup.core.features.licence.domain.model.LicenseState
import javax.inject.Inject

class LicensePreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_UNIQUE_ID = "PREF_KEY_UNIQUE_ID"
        private const val KEY_HAS_LICENSE = "PREF_KEY_HAS_LICENSE"
    }

    fun setUniqueId(value: String) = preferences.edit().putString(KEY_UNIQUE_ID, value).apply()
    fun getUniqueId() = preferences.getString(KEY_UNIQUE_ID, null)
    fun removeUniqueId() = preferences.edit().remove(KEY_UNIQUE_ID).apply()

    fun setLicense(value: Int) = preferences.edit().putInt(KEY_HAS_LICENSE, value).apply()
    fun getLicenseState() = preferences.getInt(KEY_HAS_LICENSE, LicenseState.Null.value)
    fun removeLicense() = preferences.edit().remove(KEY_HAS_LICENSE).apply()
}