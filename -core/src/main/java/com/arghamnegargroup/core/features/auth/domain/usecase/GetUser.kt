package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository

class GetUser(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke(): User? {
        return authRepository.getUser()
    }
}