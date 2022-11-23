package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.stock.domain.model.Stock

class SetSourceStock(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(id: Int?, sourceStock: Stock?): Result<Unit> {
        try {
            if (id == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.setSourceStock(id, sourceStock)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}