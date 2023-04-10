package com.arghamnegargroup.core.features.item_stock.data.dto.request

import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock
import com.google.gson.annotations.SerializedName

data class ChangeItemStocksRequest(
    @SerializedName("items")
    val items: List<ItemStock>?,
)
