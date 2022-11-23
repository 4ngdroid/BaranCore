package com.arghamnegargroup.core.features.invoice.data.remote.dto.response

import com.arghamnegargroup.core.features.core.domain.model.General
import com.google.gson.annotations.SerializedName

data class SaveSaleInvoiceResponse(
    @SerializedName("SaveSaleInvoiceByOrderResult")
    val general: General<Unit>?
)