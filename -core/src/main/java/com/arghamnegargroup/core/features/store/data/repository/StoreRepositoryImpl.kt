package com.arghamnegargroup.core.features.store.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.store.domain.model.Store
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository
import com.arghamnegargroup.core.features.store.pref.StorePreferences
import com.google.gson.Gson

class StoreRepositoryImpl(
    private val db: BaranDatabase,
    private val api: BaranApi,
    private val preferences: StorePreferences,
    private val connectionRepository: ConnectionRepository,
) : StoreRepository {

    override suspend fun getStoresLocal(): List<Store> {
        return db.storeDao().getStores()
    }

    @Throws(Throwable::class)
    override suspend fun getStoresRemote(): List<Store> {
        return api.getStores(connectionRepository.getUrl(Endpoints.GET_STORES)).result ?: emptyList()
    }

    override suspend fun saveStores(list: List<Store>) {
        db.storeDao().deleteStores()
        list.forEach { item -> db.storeDao().saveStore(item) }
    }

    override fun saveCurrentStore(store: Store) {
        preferences.setCurrentStore(Gson().toJson(store))
    }

    override fun getCurrentStore(): Store? {
        val store = preferences.getCurrentStore() ?: return null
        return Gson().fromJson(store, Store::class.java)
    }

    override fun removeCurrentStore() {
        preferences.removeCurrentStore()
    }


}