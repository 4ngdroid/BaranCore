package com.arghamnegargroup.core.features.order.data.dto.request

import com.google.gson.annotations.SerializedName

data class ResumeSuspendOrderRequest(
    @SerializedName("number")
    val number: String,
)
