package com.arghamnegargroup.core.features.auth.data.repository

import com.arghamnegargroup.core.features.auth.data.remote.dto.request.LoginRequest
import com.arghamnegargroup.core.features.auth.data.remote.dto.response.LoginResponse
import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints

class AuthRepositoryImpl(
    private val database: BaranDatabase,
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : AuthRepository {

    override suspend fun login(username: String, password: String?): LoginResponse {
        return api.login(connectionRepository.getUrl(Endpoints.GET_USER), LoginRequest(username, password))
    }

    override suspend fun saveUser(user: User) {
        database.authDao().saveUser(user)
    }

    override suspend fun getUser(): User? {
        return database.authDao().getUsers().getOrNull(0)
    }
}