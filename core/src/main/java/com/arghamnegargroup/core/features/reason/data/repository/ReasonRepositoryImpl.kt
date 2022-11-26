package com.arghamnegargroup.core.features.reason.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.reason.data.remote.dto.request.ReasonsRequest
import com.arghamnegargroup.core.features.reason.domain.model.Reason
import com.arghamnegargroup.core.features.reason.domain.repository.ReasonRepository

class ReasonRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : ReasonRepository {

    override suspend fun getReasons(request: ReasonsRequest): List<Reason> {
        return api.getReasons(connectionRepository.getUrl(Endpoints.GET_REASONS), request).reasons ?: emptyList()
    }
}