package com.arghamnegargroup.core.features.invoice.data.remote.dto.request

data class CalcInvoiceRequest(
    val order: String?,
    val calcPromotion: Boolean?,
    val calcTax: Boolean?
)