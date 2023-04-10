package com.arghamnegargroup.core.features.customer.domain.repository

import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerCreditRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.SaveCustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.UseCreditRequest
import com.arghamnegargroup.core.features.customer.data.dto.response.CustomerCreditResponse
import com.arghamnegargroup.core.features.customer.data.dto.response.UseCreditResponse
import com.arghamnegargroup.core.features.customer.domain.model.Credit
import com.arghamnegargroup.core.features.customer.domain.model.Customer
import retrofit2.http.Body
import retrofit2.http.Url

interface CustomerRepository {

    suspend fun getCustomer(request: CustomerRequest): Customer?

    suspend fun saveCustomer(request: SaveCustomerRequest): String?

    suspend fun getCustomerCredit( request: CustomerCreditRequest): Credit?

    suspend fun useCustomerCredit( request: UseCreditRequest): Result<Unit>

    suspend fun useRemainCredit( request: UseCreditRequest): Result<Unit>

}