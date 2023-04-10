package com.arghamnegargroup.core.features.section.data.remote.request


import com.google.gson.annotations.SerializedName

data class StockSectionRequest(
    @SerializedName("code")
    val code: String? = null,

    @SerializedName("stockId")
    val stockId:String? = null
)