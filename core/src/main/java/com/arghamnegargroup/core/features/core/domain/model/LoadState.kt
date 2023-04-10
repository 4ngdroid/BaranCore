package com.arghamnegargroup.core.features.core.domain.model

sealed class LoadState {
    object NotLoading : LoadState()
    object Loading : LoadState()
    data class Error(val message: String? = null) : LoadState() {
        override fun equals(other: Any?): Boolean {
            return false
        }

        override fun hashCode(): Int {
            return message?.hashCode() ?: 0
        }
    }
}