package com.arghamnegargroup.core.features.customer.data.dto.request


import com.google.gson.annotations.SerializedName

data class CustomerCreditRequest(
    @SerializedName("customerId")
    val customerId: String? = null,
    @SerializedName("getPartialPaymentCredit")
    val getPartialPaymentCredit: Boolean? = null
)