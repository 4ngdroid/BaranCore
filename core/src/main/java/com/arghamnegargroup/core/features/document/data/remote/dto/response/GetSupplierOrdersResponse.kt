package com.arghamnegargroup.core.features.document.data.remote.dto.response

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.google.gson.annotations.SerializedName

data class GetSupplierOrdersResponse(
    @SerializedName("GetSupplierOrdersForRecieveResult")
    val documents: List<Document>?
)