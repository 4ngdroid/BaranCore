package com.arghamnegargroup.core.features.stock.domain.usecase

import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class GetStocks(
    private val repository: StockRepository,
) {

    suspend operator fun invoke(): Result<List<Stock>> {
        return try {
            val stocks = repository.getStocksRemote()
            repository.saveStocks(stocks)
            Result.success(stocks)
        } catch (e: Throwable) {
            Result.success(repository.getStocksLocal())
        }
    }
}