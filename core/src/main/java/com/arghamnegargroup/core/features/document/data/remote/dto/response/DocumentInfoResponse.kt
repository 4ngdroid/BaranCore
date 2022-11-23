package com.arghamnegargroup.core.features.document.data.remote.dto.response

import com.arghamnegargroup.core.features.document.domain.model.Document
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DocumentInfoResponse(
    @SerializedName("GetDocumentInfoResult")
    val document: Document?,
)