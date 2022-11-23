package com.arghamnegargroup.core.features.store.domain.repository

import com.arghamnegargroup.core.features.store.domain.model.Store

interface StoreRepository {

    suspend fun getStoresLocal(): List<Store>

    suspend fun getStoresRemote(): List<Store>

    suspend fun saveStores(list: List<Store>)

    fun saveCurrentStore(store: Store)

    fun getCurrentStore(): Store?

    fun removeCurrentStore()
}