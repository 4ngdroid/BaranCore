package com.arghamnegargroup.core.features.auth.domain.repository

import com.arghamnegargroup.core.features.auth.data.remote.dto.response.LoginResponse
import com.arghamnegargroup.core.features.auth.data.repository.AuthPreferences
import com.arghamnegargroup.core.features.auth.domain.model.User

interface AuthRepository {

    suspend fun login(username: String, password: String?): LoginResponse

    suspend fun logout()

    suspend fun saveUser(user: User)

    suspend fun getUser(): User?

    fun setLastUsername(value: String?)
    fun getLastUsername(): String

    fun setUserId(value: String?)
    fun getUserId(): String?
}