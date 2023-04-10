package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository

class GetLastUsername(
    private val authRepository: AuthRepository
) {

    operator fun invoke(): String {
        return authRepository.getLastUsername()
    }
}