package com.arghamnegargroup.core.features.section.data.remote.response

import com.arghamnegargroup.core.features.section.domain.model.Section
import com.google.gson.annotations.SerializedName

data class StockSectionResponse(
    @SerializedName("GetStockSectionResult")
    val section: Section?
)
