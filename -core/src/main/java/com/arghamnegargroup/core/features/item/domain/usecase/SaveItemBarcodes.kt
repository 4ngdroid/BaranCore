package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository

class SaveItemBarcodes(
    private val itemRepository: ItemRepository,
) {

    suspend operator fun invoke(): Result<Unit> {
        return try {
            val items = itemRepository.getItemBarcodes()
            itemRepository.saveItemBarcodes(items)
            Result.success(Unit)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}