package com.arghamnegargroup.core.features.invoice.data.remote.dto.response

import com.arghamnegargroup.core.features.order.domain.model.Order
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CalcInvoiceResponse(
    @SerializedName("CalcInvoiceResult")
    private val order: String?
) {
    fun getOrder(): Order? {
        return Gson().fromJson(order, Order::class.java)
    }
}
