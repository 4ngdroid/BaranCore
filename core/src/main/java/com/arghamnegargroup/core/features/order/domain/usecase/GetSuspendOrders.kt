package com.arghamnegargroup.core.features.order.domain.usecase

import com.arghamnegargroup.core.features.order.domain.model.SuspendOrder
import com.arghamnegargroup.core.features.order.domain.repository.OrderRepository

class GetSuspendOrders(
    private val repository: OrderRepository,
) {

    suspend operator fun invoke(): Result<List<SuspendOrder>> {
        return try {
            Result.success(repository.getSuspendOrders())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}