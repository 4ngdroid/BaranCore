package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.data.remote.dto.request.GetSupplierOrdersRequest
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class GetSupplierOrders(
    private val repository: DocumentRepository
) {

    suspend operator fun invoke(supplierId: String?): Result<List<Document>> {
        return try {
            if (supplierId == null) throw NullPointerException("کد تامین کننده را پر کنید.")
            val documents = repository.getSupplierOrders(GetSupplierOrdersRequest(supplierId))
            Result.success(documents)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}