package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class SaveDocument(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(document: Document?): Result<Long> {
        try {
            if (document == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            val id = repository.saveDocument(document)
            return Result.success(id)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}