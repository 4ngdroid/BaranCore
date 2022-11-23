package com.arghamnegargroup.core.features.customer.domain.repository

import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.SaveCustomerRequest
import com.arghamnegargroup.core.features.customer.domain.model.Customer

interface CustomerRepository {

    suspend fun getCustomer(request: CustomerRequest): Customer?

    suspend fun saveCustomer(request: SaveCustomerRequest): String?

}