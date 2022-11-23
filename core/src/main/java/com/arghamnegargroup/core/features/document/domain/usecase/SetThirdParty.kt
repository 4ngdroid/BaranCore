package com.arghamnegargroup.core.features.document.domain.usecase

import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty

class SetThirdParty(
    private val repository: DocumentRepository,
) {

    suspend operator fun invoke(id: Int?, thirdParty: ThirdParty?): Result<Unit> {
        try {
            if (id == null)
                return Result.failure(NullPointerException("سند فعلی الزامی است."))
            repository.setThirdParty(id, thirdParty)
            return Result.success(Unit)
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}