package com.arghamnegargroup.core.features.order.domain.usecase

import com.arghamnegargroup.core.features.order.data.dto.request.SuspendOrderRequest
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.arghamnegargroup.core.features.order.domain.repository.OrderRepository

class SuspendOrder(
    private val repository: OrderRepository,
) {

    suspend operator fun invoke(
        order: Order?, sitNumber: String?, suspendNumber: String?, tableID: String?, allowPrint: Boolean,
    ): Result<String?> {
        return try {
            if (order == null) {
                throw NullPointerException("سفارش خالی است.")
            }
            Result.success(repository.suspendOrder(
                SuspendOrderRequest(order, sitNumber, suspendNumber, tableID, allowPrint))
            )
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}