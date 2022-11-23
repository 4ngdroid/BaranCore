package com.arghamnegargroup.core.features.quickitems.domain.usecase

import com.arghamnegargroup.core.features.quickitems.domain.model.QuickItems
import com.arghamnegargroup.core.features.quickitems.domain.repository.QuickItemsRepository

class GetQuickItems(
    private val repository: QuickItemsRepository,
) {

    suspend operator fun invoke(): Result<QuickItems> {
        return try {
            Result.success(repository.getQuickItems())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}