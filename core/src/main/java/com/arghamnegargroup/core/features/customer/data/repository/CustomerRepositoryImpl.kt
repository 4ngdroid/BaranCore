package com.arghamnegargroup.core.features.customer.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.SaveCustomerRequest
import com.arghamnegargroup.core.features.customer.domain.model.Customer
import com.arghamnegargroup.core.features.customer.domain.repository.CustomerRepository
import java.lang.Exception

class CustomerRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : CustomerRepository {

    override suspend fun getCustomer(request: CustomerRequest): Customer? {
        return api.getCustomer(connectionRepository.getUrl(Endpoints.GET_CUSTOMER_BY_CODE), request).getCustomer()
    }

    override suspend fun saveCustomer(request: SaveCustomerRequest): String? {
        val id = api.saveCustomer(connectionRepository.getUrl(Endpoints.SAVE_CUSTOMER), request).result
        if (id == "00000000-0000-0000-0000-000000000000")
            throw Exception("مشتری یافت نشد.")
        return id
    }
}