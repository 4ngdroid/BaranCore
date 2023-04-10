package com.arghamnegargroup.core.features.item_stock.domain.usecase

import com.arghamnegargroup.core.features.item_stock.data.dto.request.ChangeItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock
import com.arghamnegargroup.core.features.item_stock.domain.repository.ItemStocksRepository

class ChangeItemStocks(
    private val repository: ItemStocksRepository
) {

    suspend operator fun invoke(itemStocks: List<ItemStock>?): Result<Unit> {
        return try {
            if (itemStocks.isNullOrEmpty()) {
                throw NullPointerException("لیست آیتم ها خالی است")
            }
            repository.changeItemStocks(ChangeItemStocksRequest(itemStocks))
            Result.success(Unit)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}