package com.arghamnegargroup.core.features.customer.data.dto.response

import com.arghamnegargroup.core.features.customer.domain.model.Customer
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class CustomerResponse(
    @SerializedName("GetCustomerByCodeResult")
    val getCustomerByCodeResult: String?
) {
    fun getCustomer(): Customer? =
        Gson().fromJson(this.getCustomerByCodeResult, Customer::class.java)

}