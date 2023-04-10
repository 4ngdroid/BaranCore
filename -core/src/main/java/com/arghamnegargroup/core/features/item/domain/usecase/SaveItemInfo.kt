package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.item.data.remote.dto.request.SaveItemInfoRequest
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository

class SaveItemInfo(
    private val repository: ItemRepository,
) {

    suspend operator fun invoke(item: Item): Result<Unit> {
        return try {
            repository.saveItemInfo(SaveItemInfoRequest(item))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}