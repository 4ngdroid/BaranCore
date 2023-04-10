package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty

class DeleteDocument(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(id: Int?): Result<Unit> {
        try {
            if (id == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.deleteDocument(id)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}