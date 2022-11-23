package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.data.remote.dto.request.BookStockDocumentRequest
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class BookDocument(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(document: Document?): Result<Unit> {
        try {
            if (document == null)
                return Result.failure(NullPointerException("سند فعلی یافت نشد."))
            return repository.bookDocument(BookStockDocumentRequest(document))
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}