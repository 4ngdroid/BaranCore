package com.arghamnegargroup.core.features.invoice.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class ReturnInvoiceRequest(
    @SerializedName(value = "order")
    val order: String? = null,
    @SerializedName(value = "invoiceNumber")
    val invoiceNumber: String?,
)