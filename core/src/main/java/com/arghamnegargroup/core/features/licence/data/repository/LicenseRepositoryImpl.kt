package com.arghamnegargroup.core.features.licence.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.licence.data.dto.request.LicenseRequest
import com.arghamnegargroup.core.features.licence.domain.model.LicenseType
import com.arghamnegargroup.core.features.licence.domain.repository.LicenseRepository

class LicenseRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : LicenseRepository {

    override suspend fun validate(hardwareId: String, type: LicenseType): Boolean {
        return api.validateLicense(
            connectionRepository.getUrl(Endpoints.VALIDATE_LICENSE),
            LicenseRequest(hardwareId, type.code)
        ).result
    }
}