package com.arghamnegargroup.core.features.item.data.remote.dto.request

import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.SerializedName

data class SaveItemInfoRequest(
    @SerializedName("item")
    val item: Item
)
