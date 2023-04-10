package com.arghamnegargroup.core.features.connectivity.domain.usecase

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository

class IsSettingEmpty(
    private val repository: ConnectionRepository
) {
    operator fun invoke(): Boolean {
        return repository.isSettingEmpty()
    }
}