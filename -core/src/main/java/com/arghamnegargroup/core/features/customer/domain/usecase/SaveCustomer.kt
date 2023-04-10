package com.arghamnegargroup.core.features.customer.domain.usecase

import com.arghamnegargroup.core.features.customer.data.dto.request.SaveCustomerRequest
import com.arghamnegargroup.core.features.customer.domain.model.Customer
import com.arghamnegargroup.core.features.customer.domain.repository.CustomerRepository

class SaveCustomer(
    private val repository: CustomerRepository,
) {

    suspend operator fun invoke(customer: Customer?): Result<String?> {
        return try {
            if (customer == null)
                throw NullPointerException("مشتری خالی است.")
            Result.success(repository.saveCustomer(SaveCustomerRequest(customer)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}