package com.arghamnegargroup.core.features.item_stock.domain.usecase

import com.arghamnegargroup.core.features.item_stock.data.dto.request.ItemStocksRequest
import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock
import com.arghamnegargroup.core.features.item_stock.domain.repository.ItemStocksRepository

class GetItemStocks(
    private val repository: ItemStocksRepository
) {

    suspend operator fun invoke(
        barcode: String?,
        stockId: String? = null,
        allowDivide: Boolean? = null,
        forSale: Boolean? = null
    ): Result<List<ItemStock>> {
        return try {
            if (barcode.isNullOrEmpty()) {
                throw NullPointerException("بارکد خالی است")
            }
            val itemStocks = repository.getItemStocks(ItemStocksRequest(barcode, stockId, allowDivide, forSale))
            if (itemStocks.isNullOrEmpty()) {
                throw NoSuchElementException("کالایی یافت نشد")
            }

            return Result.success(itemStocks.map { it.copy(barcode = barcode) })
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}