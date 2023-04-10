package com.arghamnegargroup.core.features.customer.data.dto.response


import com.arghamnegargroup.core.features.core.domain.model.General
import com.google.gson.annotations.SerializedName

data class UseCreditResponse(
    @SerializedName("UseCustomerCreditResult")
    val general: General<Unit>?
)