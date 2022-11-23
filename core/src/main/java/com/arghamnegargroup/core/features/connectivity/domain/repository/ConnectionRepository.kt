package com.arghamnegargroup.core.features.connectivity.domain.repository

import com.arghamnegargroup.core.features.connectivity.data.pref.ConnectionPreferences

interface ConnectionRepository {

    fun getIP(): String?
    fun setIP(IP: String)
    fun removeIP()

    fun getPort(): String?
    fun setPort(port: String)
    fun removePort()

    fun getUsername(): String?
    fun setUsername(username: String)
    fun removeUsername()

    fun getPassword(): String?
    fun setPassword(password: String)
    fun removePassword()

    fun getUrl(): String
    fun getUrl(endpoint: String): String
    fun getCredentials(): String
}