package com.arghamnegargroup.core.features.order.data.dto.response

import com.arghamnegargroup.core.features.order.domain.model.Order
import com.google.gson.annotations.SerializedName

data class ResumeSuspendOrderResponse(
    @SerializedName("ResumeSuspendOrderResult")
    var result: Order?,
)