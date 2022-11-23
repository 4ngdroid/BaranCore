package com.arghamnegargroup.core.features.item.data.remote.dto.response


import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("SearchItemResult")
    val result: List<Item>
)