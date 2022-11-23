package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.item.data.remote.dto.request.ItemInfoRequest
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class GetItemInfo(
    private val repository: ItemRepository,
    private val stockRepository: StockRepository,
) {

    suspend operator fun invoke(barcode: String?, stockId: String? = null, supplierId: String? = null): Result<Item> {
        try {
            if (barcode == null)
                return Result.failure(NullPointerException("لطفا بارکد را پر کنید."))

            val item = repository.getItemInfo(ItemInfoRequest(
                barcode = barcode,
                stockId = stockId ?: stockRepository.getCurrentStock()?.stockID,
                supplierId = supplierId)
            ) ?: return Result.failure(NullPointerException("کالا یافت نشد."))

            return Result.success(item)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}