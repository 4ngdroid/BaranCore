package com.arghamnegargroup.core.features.licence.data.dto.request

import com.google.gson.annotations.SerializedName

data class LicenseRequest(
    @SerializedName("hID")
    val hardwareId: String,
    @SerializedName("type")
    val type: Int,
)
