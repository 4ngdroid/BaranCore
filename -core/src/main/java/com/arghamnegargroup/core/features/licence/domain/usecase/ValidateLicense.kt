package com.arghamnegargroup.core.features.licence.domain.usecase

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.provider.Settings.*
import android.provider.Settings.Secure.*
import android.util.Log
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.core.util.common.Utils.retryIO
import com.arghamnegargroup.core.features.licence.domain.model.LicenseType
import com.arghamnegargroup.core.features.licence.domain.repository.LicenseRepository

class ValidateLicense(
    private val repository: LicenseRepository
) {

    @SuppressLint("HardwareIds")
    suspend operator fun invoke(context: Context): Boolean? {
        Log.i(TAG, "ValidateLicenseUseCase performed!")
        val secureId = getString(context.contentResolver, ANDROID_ID)

        return retryIO {
            try {
                when (context.packageName) {
                    "com.arghamnegargroup.pda" -> {
                        repository.validate(secureId, LicenseType.PDA)
                    }
                    else -> {
                        repository.validate(secureId, LicenseType.Kiosk)
                    }
                }
            } catch (e: Throwable) {
                null
            }
        }
    }
}