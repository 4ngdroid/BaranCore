package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty

class GetLastDocument(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(): Result<Document> {
        return try {
            val document = repository.getLastDocument() ?: throw NullPointerException()
            Result.success(document)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}