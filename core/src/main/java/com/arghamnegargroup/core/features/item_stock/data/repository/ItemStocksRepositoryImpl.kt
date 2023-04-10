package com.arghamnegargroup.core.features.item_stock.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.core.data.remote.Endpoints.CHANGE_ITEM_STOCKS
import com.arghamnegargroup.core.features.item_stock.data.dto.request.ChangeItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.data.dto.request.ItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock
import com.arghamnegargroup.core.features.item_stock.domain.repository.ItemStocksRepository

class ItemStocksRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : ItemStocksRepository {

    override suspend fun getItemStocks(request: ItemStocksRequest): List<ItemStock>? {
        return try {
            api.getItemStocks(connectionRepository.getUrl(Endpoints.GET_ITEM_STOCKS), request).itemStocks
        } catch (e: Throwable) {
            null
        }
    }

    override suspend fun changeItemStocks(request: ChangeItemStocksRequest) {
        return api.changeItemStocks(connectionRepository.getUrl(CHANGE_ITEM_STOCKS), request)
    }

}