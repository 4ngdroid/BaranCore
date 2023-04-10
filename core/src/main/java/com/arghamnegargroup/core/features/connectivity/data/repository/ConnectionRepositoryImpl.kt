package com.arghamnegargroup.core.features.connectivity.data.repository

import android.util.Base64
import com.arghamnegargroup.core.features.connectivity.data.pref.ConnectionPreferences
import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.util.ext.toLatinDigits

class ConnectionRepositoryImpl(
    private val preferences: ConnectionPreferences,
) : ConnectionRepository {
    override fun getIP(): String {
        return preferences.getIP() ?: ""
    }

    override fun setIP(IP: String) {
        return preferences.setIP(IP)
    }

    override fun removeIP() {
        return preferences.removeIP()
    }

    override fun getPort(): String {
        return preferences.getPort() ?: ""
    }

    override fun setPort(port: String) {
        return preferences.setPort(port)
    }

    override fun removePort() {
        return preferences.removePort()
    }

    override fun getUsername(): String {
        return preferences.getUsername() ?: ""
    }

    override fun setUsername(username: String) {
        return preferences.setUsername(username)
    }

    override fun removeUsername() {
        return preferences.removeUsername()
    }

    override fun getPassword(): String {
        return preferences.getPassword() ?: ""
    }

    override fun setPassword(password: String) {
        return preferences.setPassword(password)
    }

    override fun removePassword() {
        return preferences.removePassword()
    }

    override fun getUrl(): String {
        val ip = getIP().toLatinDigits()
        val port = getPort().toLatinDigits()
        return "http://$ip:$port/RainSaleService.svc"
    }

    override fun getUrl(endpoint: String): String {
        return "${getUrl()}/$endpoint"
    }

    override fun getCredentials(): String {
        return "Basic " + Base64.encodeToString(
            "${getUsername()}:${getPassword()}".toByteArray(),
            Base64.NO_WRAP
        )
    }

    override fun isSettingEmpty(): Boolean {
        return getIP().isEmpty() || getPort().isEmpty() || getUsername().isEmpty() || getPassword().isEmpty()
    }
}