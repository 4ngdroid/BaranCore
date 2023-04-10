package com.arghamnegargroup.core.features.order.data.dto.response

import com.arghamnegargroup.core.features.core.domain.model.General
import com.google.gson.annotations.SerializedName

data class SuspendOrderResponse(
    @SerializedName("SuspendOrderResult")
    var result: General<Unit>?,
)