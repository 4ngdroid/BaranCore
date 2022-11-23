package com.arghamnegargroup.core.features.stock.data.remote.dto.response

import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class StockResponse(
        @SerializedName("GetAllStockResult")
        val result: List<Stock>?
)