package com.arghamnegargroup.core.features.customer.domain.usecase

import com.arghamnegargroup.core.features.customer.data.dto.request.UseCreditRequest
import com.arghamnegargroup.core.features.customer.domain.repository.CustomerRepository

class UseRemainCredit(
    private val repository: CustomerRepository,
) {

    suspend operator fun invoke(
        customerId: String,
        amount: Double,
        groupId: String? = null,
        point: Double? = null,
        description: String? = null,
        storeId: Int? = null,
        workStationId: Int? = null,
        invoiceId: String? = null,
    ): Result<Unit> {
        return try {
            repository.useRemainCredit(
                UseCreditRequest(
                    customerId,
                    amount,
                    groupId,
                    point,
                    description,
                    storeId,
                    workStationId,
                    invoiceId)
            )
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}