package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class SaveDocument(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(document: Document?): Result<Unit> {
        try {
            if (document == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.saveDocument(document)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}