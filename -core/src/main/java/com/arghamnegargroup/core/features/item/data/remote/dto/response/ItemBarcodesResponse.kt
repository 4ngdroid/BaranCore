package com.arghamnegargroup.core.features.item.data.remote.dto.response

import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode
import com.google.gson.annotations.SerializedName

data class ItemBarcodesResponse(
    @SerializedName("GetItemBarcodesResult")
    val barcodes :List<ItemBarcode>?
)
