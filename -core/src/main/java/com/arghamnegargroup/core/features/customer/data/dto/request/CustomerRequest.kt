package com.arghamnegargroup.core.features.customer.data.dto.request

import com.google.gson.annotations.SerializedName

data class CustomerRequest(
    @SerializedName("customerCode")
    val customerCode: String,
    @SerializedName("password")
    val password: String? = null
)