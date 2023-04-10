package com.arghamnegargroup.core.features.item.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class ItemInfoRequest(
    @SerializedName("barcode")
    val barcode: String?,
    @SerializedName("stockId")
    val stockId: String? = null,
    @SerializedName("supplierId")
    val supplierId: String? = null,
)