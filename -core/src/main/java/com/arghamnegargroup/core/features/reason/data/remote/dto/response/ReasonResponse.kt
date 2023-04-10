package com.arghamnegargroup.core.features.reason.data.remote.dto.response


import com.arghamnegargroup.core.features.reason.domain.model.Reason
import com.google.gson.annotations.SerializedName

data class ReasonResponse(
    @SerializedName("GetReasonsResult")
    val reasons: List<Reason>?
)