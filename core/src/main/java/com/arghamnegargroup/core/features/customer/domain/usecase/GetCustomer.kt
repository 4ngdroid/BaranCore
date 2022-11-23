package com.arghamnegargroup.core.features.customer.domain.usecase

import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerRequest
import com.arghamnegargroup.core.features.customer.domain.model.Customer
import com.arghamnegargroup.core.features.customer.domain.repository.CustomerRepository

class GetCustomer(
    private val repository: CustomerRepository,
) {

    suspend operator fun invoke(code: String?, password: String? = null): Result<Customer?> {
        return try {
            if (code == null)
                throw NullPointerException("کد مشتری را پر کنید.")
            Result.success(repository.getCustomer(CustomerRequest(code, password)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}