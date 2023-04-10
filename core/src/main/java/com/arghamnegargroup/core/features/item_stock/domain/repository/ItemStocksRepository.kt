package com.arghamnegargroup.core.features.item_stock.domain.repository

import com.arghamnegargroup.core.features.item_stock.data.dto.request.ChangeItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.data.dto.request.ItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock

interface ItemStocksRepository {

    suspend fun getItemStocks(request: ItemStocksRequest): List<ItemStock>?

    suspend fun changeItemStocks(request: ChangeItemStocksRequest)
}