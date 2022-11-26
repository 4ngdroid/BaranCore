package com.arghamnegargroup.core.features.reason.domain.repository

import com.arghamnegargroup.core.features.reason.data.remote.dto.request.ReasonsRequest
import com.arghamnegargroup.core.features.reason.domain.model.Reason

interface ReasonRepository {

    suspend fun getReasons(request: ReasonsRequest): List<Reason>

}