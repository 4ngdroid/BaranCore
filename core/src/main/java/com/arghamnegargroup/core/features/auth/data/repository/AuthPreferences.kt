package com.arghamnegargroup.core.features.auth.data.repository

import android.content.SharedPreferences
import javax.inject.Inject

class AuthPreferences @Inject constructor(
    private val preferences: SharedPreferences
) {

    companion object {
        private const val KEY_LAST_USERNAME = "PREF_KEY_LAST_USERNAME"
        private const val KEY_USER_ID = "PREF_KEY_USER_ID"
    }

    fun setLastUsername(value: String) = preferences.edit().putString(KEY_LAST_USERNAME, value).apply()
    fun getLastUsername(): String? = preferences.getString(KEY_LAST_USERNAME, null)
    fun removeLastUsername() = preferences.edit().remove(KEY_LAST_USERNAME).apply()

    fun setUserId(value: String?) = preferences.edit().putString(KEY_USER_ID, value).apply()
    fun getUserId(): String? = preferences.getString(KEY_USER_ID, null)
    fun removeUserId() = preferences.edit().remove(KEY_USER_ID).apply()
}