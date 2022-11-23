package com.arghamnegargroup.core.features.stock.domain.repository

import com.arghamnegargroup.core.features.stock.domain.model.Stock

interface StockRepository {

    suspend fun getStocksLocal(): List<Stock>

    suspend fun getStocksRemote(): List<Stock>

    suspend fun saveStocks(list: List<Stock>)

    fun saveCurrentStock(stock: Stock)

    fun getCurrentStock(): Stock?

    fun removeCurrentStock()
}