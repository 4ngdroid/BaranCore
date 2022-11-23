package com.arghamnegargroup.core.features.invoice.data.remote.dto.request

import com.arghamnegargroup.core.features.order.domain.model.Order
import com.google.gson.annotations.SerializedName

data class SaleInvoiceRequest(
    @SerializedName("order")
    val order: Order?,
    @SerializedName("calcPromotion")
    val calcPromotion: Boolean?,
    @SerializedName("calcTax")
    val calcTax: Boolean?,
    @SerializedName("allowToMakeInvoice")
    val allowToMakeInvoice: Boolean?,
    @SerializedName("useCredit")
    val useCredit: Boolean = true
)