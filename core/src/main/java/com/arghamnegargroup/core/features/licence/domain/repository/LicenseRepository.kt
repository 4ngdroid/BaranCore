package com.arghamnegargroup.core.features.licence.domain.repository

import com.arghamnegargroup.core.features.licence.domain.model.LicenseState
import com.arghamnegargroup.core.features.licence.domain.model.LicenseType

interface LicenseRepository {

    suspend fun validate(type: LicenseType): Boolean

    fun setUniqueId(value: String)
    fun getUniqueId(): String
    fun removeUniqueId()

    fun setLicense(value: LicenseState)
    fun getLicenseState(): LicenseState
    fun removeLicense()
}