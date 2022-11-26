package com.arghamnegargroup.core.features.invoice.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class GetInvoiceRequest(
    @SerializedName(value = "invoiceNumber")
    val invoiceNumber: String?,
)