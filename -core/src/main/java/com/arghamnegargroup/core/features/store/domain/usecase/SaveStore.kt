package com.arghamnegargroup.core.features.store.domain.usecase

import com.arghamnegargroup.core.features.store.domain.model.Store
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository

class SaveStore(
    private val repository: StoreRepository
) {

    operator fun invoke(store: Store) {
        return repository.saveCurrentStore(store)
    }
}