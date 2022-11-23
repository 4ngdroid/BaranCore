package com.arghamnegargroup.core.features.stock.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.stock.data.pref.StockPreferences
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository
import com.google.gson.Gson

class StockRepositoryImpl(
    private val db: BaranDatabase,
    private val api: BaranApi,
    private val preferences: StockPreferences,
    private val connectionRepository: ConnectionRepository,
) : StockRepository {

    override suspend fun getStocksLocal(): List<Stock> {
        return db.stockDao().getStocks()
    }

    @Throws(Throwable::class)
    override suspend fun getStocksRemote(): List<Stock> {
        return api.getStocks(connectionRepository.getUrl(Endpoints.GET_ALL_STOCKS)).result ?: emptyList()
    }

    override suspend fun saveStocks(list: List<Stock>) {
        db.stockDao().deleteStocks()
        list.forEach { item -> db.stockDao().saveStock(item) }
    }

    override fun saveCurrentStock(stock: Stock) {
        preferences.setCurrentStock(Gson().toJson(stock))
    }

    override fun getCurrentStock(): Stock? {
        val stock = preferences.getCurrentStock() ?: return null
        return Gson().fromJson(stock, Stock::class.java)
    }

    override fun removeCurrentStock() {
        preferences.removeCurrentStock()
    }


}