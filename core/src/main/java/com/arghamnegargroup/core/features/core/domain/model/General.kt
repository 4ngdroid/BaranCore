package com.arghamnegargroup.core.features.core.domain.model


import com.google.gson.annotations.SerializedName

data class General<T>(
    @SerializedName("Date")
    val date: String?,
    @SerializedName("Index")
    val index: String?,
    @SerializedName("Message")
    val message: String?,
    @SerializedName("Status")
    val status: Int
)