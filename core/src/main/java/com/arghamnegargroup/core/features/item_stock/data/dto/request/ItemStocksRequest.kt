package com.arghamnegargroup.core.features.item_stock.data.dto.request


import com.google.gson.annotations.SerializedName

data class ItemStocksRequest(
    @SerializedName("barcode")
    val barcode: String?,
    @SerializedName("stockId")
    val stockId: String?,
    @SerializedName("allowDevide")
    val allowDivide: Boolean?,
    @SerializedName("forSale")
    val forSale: Boolean?,
)