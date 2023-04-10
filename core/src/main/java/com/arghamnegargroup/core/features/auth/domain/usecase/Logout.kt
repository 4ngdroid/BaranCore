package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository

class Logout(
    private val authRepository: AuthRepository,
) {

    suspend operator fun invoke() {
        authRepository.logout()
    }
}