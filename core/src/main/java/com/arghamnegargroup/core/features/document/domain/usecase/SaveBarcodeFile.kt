package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.data.remote.dto.request.SaveBarcodeFileRequest
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository

class SaveBarcodeFile(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(document: SaveBarcodeFileRequest.Document?, saveInDatabase: Boolean?): Result<Unit> {
        try {
            if (document == null)
                return Result.failure(NullPointerException("سند ارسالی الزامی میباشد."))
            return repository.saveBarcodeFile(SaveBarcodeFileRequest(document, saveInDatabase))
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}