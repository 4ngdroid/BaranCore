package com.arghamnegargroup.core.features.stock.domain.usecase

import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository

class GetStock(
    val repository: StockRepository
) {

    operator fun invoke(): Stock? {
        return repository.getCurrentStock()
    }
}