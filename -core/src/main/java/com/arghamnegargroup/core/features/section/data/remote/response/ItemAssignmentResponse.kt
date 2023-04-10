package com.arghamnegargroup.core.features.section.data.remote.response

import com.arghamnegargroup.core.features.core.domain.model.General
import com.google.gson.annotations.SerializedName

data class ItemAssignmentResponse(
    @SerializedName("ItemAssignmentToSectionResult")
    val result: General<Unit>,
)
