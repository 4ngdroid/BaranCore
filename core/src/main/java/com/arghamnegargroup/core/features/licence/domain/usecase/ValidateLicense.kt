package com.arghamnegargroup.core.features.licence.domain.usecase

import android.content.Context
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.core.util.common.Utils.retryIO
import com.arghamnegargroup.core.features.licence.domain.model.LicenseState
import com.arghamnegargroup.core.features.licence.domain.model.LicenseState.Companion.toBoolean
import com.arghamnegargroup.core.features.licence.domain.model.LicenseType
import com.arghamnegargroup.core.features.licence.domain.repository.LicenseRepository

class ValidateLicense(
    private val context: Context,
    private val repository: LicenseRepository
) {

    suspend operator fun invoke(): Boolean? {
        return retryIO {
            try {
                return@retryIO validate()
            } catch (e: Throwable) {
                return@retryIO repository.getLicenseState().toBoolean()
            }
        }
    }

    private suspend fun validate(): Boolean {
        return when (context.packageName) {
            "com.arghamnegargroup.pda" -> {
                repository.validate(LicenseType.PDA)
            }
            else -> {
                repository.validate(LicenseType.Kiosk)
            }
        }
    }
}