package com.arghamnegargroup.core.features.licence.data.dto.response

import com.google.gson.annotations.SerializedName

data class LicenseResponse(
    @SerializedName("ValidateLicenseResult")
    val result: Boolean
)
