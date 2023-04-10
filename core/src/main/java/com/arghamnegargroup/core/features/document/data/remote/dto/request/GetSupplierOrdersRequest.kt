package com.arghamnegargroup.core.features.document.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class GetSupplierOrdersRequest(
    @SerializedName("supplierId")
    val supplierId: String
)