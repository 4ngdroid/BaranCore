package com.arghamnegargroup.core.features.item.domain.model

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("GetItemsResult")
    val items:List<Item>
)