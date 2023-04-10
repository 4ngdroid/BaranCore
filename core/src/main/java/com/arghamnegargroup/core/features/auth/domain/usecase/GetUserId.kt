package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository

class GetUserId(
    private val authRepository: AuthRepository,
) {

    operator fun invoke(): String? {
        return authRepository.getUserId()
    }
}