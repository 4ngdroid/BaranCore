package com.arghamnegargroup.core.features.quickitems.data.remote.dto.response

import com.arghamnegargroup.core.features.quickitems.domain.model.QuickItems
import com.google.gson.annotations.SerializedName

data class QuickItemsResponse(
    @SerializedName("GetQuickItemsResult")
    val quickItems: QuickItems
)