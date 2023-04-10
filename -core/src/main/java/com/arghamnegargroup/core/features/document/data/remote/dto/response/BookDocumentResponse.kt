package com.arghamnegargroup.core.features.document.data.remote.dto.response

import com.arghamnegargroup.core.features.core.domain.model.General
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookDocumentResponse(
    @SerializedName("BookStockDocumentResult")
    @Expose
    val result: General<Item>,
)