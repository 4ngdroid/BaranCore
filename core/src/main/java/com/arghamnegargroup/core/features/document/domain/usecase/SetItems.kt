package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty

class SetItems(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(id: Int?, items: List<Item>): Result<Unit> {
        try {
            if (id == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.setItems(id, items)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}