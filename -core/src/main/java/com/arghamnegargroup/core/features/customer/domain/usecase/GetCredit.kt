package com.arghamnegargroup.core.features.customer.domain.usecase

import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerCreditRequest
import com.arghamnegargroup.core.features.customer.domain.model.Credit
import com.arghamnegargroup.core.features.customer.domain.repository.CustomerRepository

class GetCredit(
    private val repository: CustomerRepository,
) {

    suspend operator fun invoke(customerId: String?, getPartialPaymentCredit: Boolean? = null): Result<Credit?> {
        return try {
            if (customerId == null)
                throw NullPointerException("مشتری خالی است.")
            Result.success(repository.getCustomerCredit(CustomerCreditRequest(customerId, getPartialPaymentCredit)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}