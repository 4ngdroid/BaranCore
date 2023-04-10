package com.arghamnegargroup.core.features.licence.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.licence.data.dto.request.LicenseRequest
import com.arghamnegargroup.core.features.licence.data.pref.LicensePreferences
import com.arghamnegargroup.core.features.licence.domain.model.LicenseState
import com.arghamnegargroup.core.features.licence.domain.model.LicenseState.Companion.toState
import com.arghamnegargroup.core.features.licence.domain.model.LicenseType
import com.arghamnegargroup.core.features.licence.domain.repository.LicenseRepository
import java.util.UUID

class LicenseRepositoryImpl(
    private val api: BaranApi,
    private val preferences: LicensePreferences,
    private val connectionRepository: ConnectionRepository,
) : LicenseRepository {

    override suspend fun validate(type: LicenseType): Boolean {
        val result = api.validateLicense(
            connectionRepository.getUrl(Endpoints.VALIDATE_LICENSE),
            LicenseRequest(getUniqueId(), type.code)
        ).result
        setLicense(result.toState())
        return result
    }

    override fun setUniqueId(value: String) {
        preferences.setUniqueId(value)
    }

    override fun getUniqueId(): String {
        val uniqueId = preferences.getUniqueId()
        return if (uniqueId == null) {
            val id = UUID.randomUUID().toString()
            preferences.setUniqueId(id)
            id
        } else uniqueId
    }

    override fun removeUniqueId() {
        preferences.removeUniqueId()
    }

    override fun setLicense(value: LicenseState) {
        preferences.setLicense(value.value)
    }

    override fun getLicenseState(): LicenseState {
        return preferences.getLicenseState().toState()
    }

    override fun removeLicense() {
        preferences.removeLicense()
    }
}