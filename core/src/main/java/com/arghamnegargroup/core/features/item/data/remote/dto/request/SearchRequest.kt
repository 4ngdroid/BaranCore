package com.arghamnegargroup.core.features.item.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class SearchRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("userId")
    val userId: String?,
    @SerializedName("stockId")
    val stockId: String?
)