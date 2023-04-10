package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier

class SetSupplier(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(id: Int?, supplier: Supplier?): Result<Unit> {
        try {
            if (id == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.setSupplier(id, supplier)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}