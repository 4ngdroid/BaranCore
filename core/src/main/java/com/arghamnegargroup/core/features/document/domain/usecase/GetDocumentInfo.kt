package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.data.remote.dto.request.DocumentInfoRequest
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class GetDocumentInfo(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(documentCode: String?): Result<Document> {
        try {
            if (documentCode == null)
                return Result.failure(NullPointerException("کد سند الزامی میباشد."))
            val document = repository.getDocumentInfo(DocumentInfoRequest(documentCode)) ?: throw NullPointerException("سند یافت نشد.")
            return Result.success(document)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}