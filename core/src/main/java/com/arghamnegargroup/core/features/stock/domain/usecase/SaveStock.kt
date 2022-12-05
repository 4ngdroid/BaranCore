package com.arghamnegargroup.core.features.stock.domain.usecase

import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class SaveStock(
    private val repository: StockRepository
) {

    operator fun invoke(stock: Stock) {
        return repository.saveCurrentStock(stock)
    }
}