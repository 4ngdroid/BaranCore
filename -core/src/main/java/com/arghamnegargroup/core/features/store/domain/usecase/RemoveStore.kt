package com.arghamnegargroup.core.features.store.domain.usecase

import com.arghamnegargroup.core.features.store.domain.model.Store
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository

class RemoveStore(
    private val repository: StoreRepository
) {

    operator fun invoke() {
        return repository.removeCurrentStore()
    }
}