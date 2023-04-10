package com.arghamnegargroup.core.features.licence.domain.model

sealed class LicenseType(val code: Int) {
    object PDA : LicenseType(424)
    object Kiosk : LicenseType(495)
}
