package com.arghamnegargroup.core.features.licence.domain.repository

import com.arghamnegargroup.core.features.licence.domain.model.LicenseType

interface LicenseRepository {

    suspend fun validate(hardwareId: String, type: LicenseType): Boolean
}