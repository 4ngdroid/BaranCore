package com.arghamnegargroup.core.features.section.data.remote.request

import com.arghamnegargroup.core.features.section.domain.model.ItemStockSection
import com.google.gson.annotations.SerializedName

data class ItemAssignmentRequest(
    @SerializedName("items")
    val items: List<ItemStockSection>
)
