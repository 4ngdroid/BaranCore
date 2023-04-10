package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository

class GetItems(
    private val repository: ItemRepository,
) {

    suspend operator fun invoke(): Result<List<Item>> {
        return try {
            Result.success(repository.getItems())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}