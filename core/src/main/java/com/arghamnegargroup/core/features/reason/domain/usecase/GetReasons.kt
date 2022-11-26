package com.arghamnegargroup.core.features.reason.domain.usecase

import com.arghamnegargroup.core.features.reason.data.remote.dto.request.ReasonsRequest
import com.arghamnegargroup.core.features.reason.domain.model.Reason
import com.arghamnegargroup.core.features.reason.domain.repository.ReasonRepository

class GetReasons(
    private val repository: ReasonRepository,
) {

    suspend operator fun invoke(type: Int?): Result<List<Reason>> {
        return try {
            if (type == null)
                throw NullPointerException("نوع دلایل خالی میباشد.")
            Result.success(repository.getReasons(ReasonsRequest(type)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}