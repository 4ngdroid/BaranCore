package com.arghamnegargroup.core.features.item_stock.data.dto.response


import com.arghamnegargroup.core.features.item_stock.domain.model.ItemStock
import com.google.gson.annotations.SerializedName

data class ItemStocksResponse(
    @SerializedName("GetItemStocksResult")
    val itemStocks: List<ItemStock>?
)