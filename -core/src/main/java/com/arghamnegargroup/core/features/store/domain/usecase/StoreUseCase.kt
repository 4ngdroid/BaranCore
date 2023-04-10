package com.arghamnegargroup.core.features.store.domain.usecase

data class StoreUseCase(
    val getStores: GetStores,
    val getStore: GetStore,
    val saveStore: SaveStore,
    val removeStore: RemoveStore,
)
