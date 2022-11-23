package com.arghamnegargroup.core.features.item.data.remote.dto.response


import com.arghamnegargroup.core.features.core.domain.model.General
import com.google.gson.annotations.SerializedName

data class SaveItemInfoResponse(
    @SerializedName("SaveItemInfoResult")
    val result: General<Unit>
)