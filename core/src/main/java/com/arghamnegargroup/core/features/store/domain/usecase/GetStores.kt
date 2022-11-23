package com.arghamnegargroup.core.features.store.domain.usecase

import com.arghamnegargroup.core.features.store.domain.model.Store
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository

class GetStores(
    private val repository: StoreRepository,
) {

    suspend operator fun invoke(): Result<List<Store>> {
        return try {
            val stores = repository.getStoresRemote()
            repository.saveStores(stores)
            Result.success(stores)
        } catch (e: Throwable) {
            Result.success(repository.getStoresLocal())
        }
    }
}