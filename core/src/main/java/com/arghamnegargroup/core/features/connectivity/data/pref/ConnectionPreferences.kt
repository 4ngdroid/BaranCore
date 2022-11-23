package com.arghamnegargroup.core.features.connectivity.data.pref

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectionPreferences @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val KEY_IP = "PREF_KEY_IP"
        const val KEY_PORT = "PREF_KEY_PORT"
        const val KEY_USERNAME = "PREF_KEY_USERNAME"
        const val KEY_PASSWORD = "PREF_KEY_PASSWORD"
    }

    fun getIP(): String? = prefs.getString(KEY_IP, null)
    fun setIP(IP: String) = prefs.edit().putString(KEY_IP, IP).apply()
    fun removeIP() = prefs.edit().remove(KEY_IP).apply()

    fun getPort(): String? = prefs.getString(KEY_PORT, null)
    fun setPort(port: String) = prefs.edit().putString(KEY_PORT, port).apply()
    fun removePort() = prefs.edit().remove(KEY_PORT).apply()

    fun getUsername(): String? = prefs.getString(KEY_USERNAME, null)
    fun setUsername(username: String) = prefs.edit().putString(KEY_USERNAME, username).apply()
    fun removeUsername() = prefs.edit().remove(KEY_USERNAME).apply()

    fun getPassword(): String? = prefs.getString(KEY_PASSWORD, null)
    fun setPassword(password: String) = prefs.edit().putString(KEY_PASSWORD, password).apply()
    fun removePassword() = prefs.edit().remove(KEY_PASSWORD).apply()

}