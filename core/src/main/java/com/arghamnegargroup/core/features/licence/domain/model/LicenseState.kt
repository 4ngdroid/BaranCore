package com.arghamnegargroup.core.features.licence.domain.model

sealed class LicenseState(val value: Int) {
    object Verified : LicenseState(1)
    object NotVerified : LicenseState(-1)
    object Null : LicenseState(0)

    companion object {
        fun Boolean?.toState(): LicenseState {
            return when (this) {
                true -> Verified
                false -> NotVerified
                null -> Null
            }
        }

        fun Int.toState(): LicenseState {
            return when (this) {
                1 -> Verified
                -1 -> NotVerified
                else -> Null
            }
        }

        fun LicenseState.toBoolean(): Boolean? {
            return when (this) {
                Verified -> true
                NotVerified -> false
                Null -> null
            }
        }
    }
}
