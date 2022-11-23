package com.arghamnegargroup.core.features.auth.domain.repository

import com.arghamnegargroup.core.features.auth.data.remote.dto.response.LoginResponse
import com.arghamnegargroup.core.features.auth.domain.model.User

interface AuthRepository {

    suspend fun login(username: String, password: String?): LoginResponse

    suspend fun saveUser(user: User)

    suspend fun getUser() : User?
}