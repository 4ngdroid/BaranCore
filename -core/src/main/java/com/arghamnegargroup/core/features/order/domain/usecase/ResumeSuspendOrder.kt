package com.arghamnegargroup.core.features.order.domain.usecase

import com.arghamnegargroup.core.features.order.data.dto.request.ResumeSuspendOrderRequest
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.arghamnegargroup.core.features.order.domain.repository.OrderRepository

class ResumeSuspendOrder(
    private val repository: OrderRepository,
) {

    suspend operator fun invoke(number: String?): Result<Order> {
        return try {
            if (number == null) throw  NullPointerException("کد سفارش را پر کنید.")
            Result.success(repository.resumeSuspendOrder(ResumeSuspendOrderRequest(number)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}