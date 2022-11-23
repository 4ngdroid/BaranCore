package com.arghamnegargroup.core.features.customer.data.dto.response

import com.google.gson.annotations.SerializedName

data class SaveCustomerResponse(
    @SerializedName("SaveCustomerResult")
    val result: String?
)