package com.arghamnegargroup.core.features.customer.data.dto.response


import com.arghamnegargroup.core.features.customer.domain.model.Credit
import com.google.gson.annotations.SerializedName

data class CustomerCreditResponse(
    @SerializedName("GetCustomerCreditResult")
    val credit: Credit?
)