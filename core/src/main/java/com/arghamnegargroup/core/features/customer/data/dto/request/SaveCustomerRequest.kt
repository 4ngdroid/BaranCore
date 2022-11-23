package com.arghamnegargroup.core.features.customer.data.dto.request

import com.arghamnegargroup.core.features.customer.domain.model.Customer
import com.google.gson.annotations.SerializedName

data class SaveCustomerRequest(
    @SerializedName("customer")
    val customer : Customer
)