package com.arghamnegargroup.core.features.item.data.remote.dto.response

import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemInfoResponse(
        @SerializedName("GetItemInfoResult")
        @Expose
        val item: Item
)