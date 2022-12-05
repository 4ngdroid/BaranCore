package com.arghamnegargroup.core.features.stock.domain.usecase

import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class RemoveStock(
    private val repository: StockRepository
) {

    operator fun invoke() {
        return repository.removeCurrentStock()
    }
}