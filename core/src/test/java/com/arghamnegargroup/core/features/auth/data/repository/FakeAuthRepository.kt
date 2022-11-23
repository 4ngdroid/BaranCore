package com.arghamnegargroup.core.features.auth.data.repository

import com.arghamnegargroup.core.features.auth.data.remote.dto.response.LoginResponse
import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.google.gson.Gson

class FakeAuthRepository : AuthRepository {

    private val users = mutableListOf<User>()

    override suspend fun login(username: String, password: String?): LoginResponse {
        return Gson().fromJson(response, LoginResponse::class.java)
    }

    override suspend fun saveUser(user: User) {
        users.clear()
        users.add(user)
    }

    override suspend fun getUser(): User? {
        return users.getOrNull(0)
    }
}