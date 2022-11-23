package com.arghamnegargroup.core.features.reason.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class ReasonsRequest(
    @SerializedName("type")
    val type: Int = 5
)