package com.arghamnegargroup.core.features.item_stock.domain.model


import com.google.gson.annotations.SerializedName

data class ItemStock(
    @SerializedName("AllowChangePrice")
    val allowChangePrice: Boolean?,
    @SerializedName("AllowOnlineSale")
    val allowOnlineSale: Boolean?,
    @SerializedName("AllowOrder")
    val allowOrder: Boolean?,
    @SerializedName("AllowRecieve")
    val allowReceive: Boolean?,
    @SerializedName("AllowReturn")
    val allowReturn: Boolean?,
    @SerializedName("AllowSale")
    val allowSale: Boolean?,
    @SerializedName("ItemID")
    val itemId: String?,
    @SerializedName("ItemName")
    val name: String?,
    @SerializedName("Quantity")
    val quantity: Int?,
    @SerializedName("Status")
    val status: Boolean?,
    @SerializedName("StockID")
    val stockId: String?,
    @SerializedName("StockName")
    val stockName: String?,
    val barcode: String?
)