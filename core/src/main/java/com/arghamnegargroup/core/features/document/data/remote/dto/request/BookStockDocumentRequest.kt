package com.arghamnegargroup.core.features.document.data.remote.dto.request

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.google.gson.annotations.SerializedName

data class BookStockDocumentRequest(
        @SerializedName("document")
        val document: Document
)