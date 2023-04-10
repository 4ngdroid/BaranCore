package com.arghamnegargroup.core.features.document.data.remote.dto.request

import com.google.gson.annotations.SerializedName

data class DocumentInfoRequest(
    @SerializedName("documentCode")
    val documentCode: String,
    @SerializedName("removeConfirmed")
    val removeConfirmed: Boolean = true
)