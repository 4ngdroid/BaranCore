package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository

class GetItemBarcode(
    private val itemRepository: ItemRepository,
) {

    suspend operator fun invoke(barcode: String?): Result<Item?> {
        try {
            if (barcode == null) {
                return Result.failure(NullPointerException("بارکد را پر کنید."))
            }
            val item = itemRepository.getItemBarcode(barcode)
            return Result.success(item)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}