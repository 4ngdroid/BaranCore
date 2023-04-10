package com.arghamnegargroup.core.features.order.domain.repository

import com.arghamnegargroup.core.features.order.data.dto.request.ResumeSuspendOrderRequest
import com.arghamnegargroup.core.features.order.data.dto.request.SuspendOrderRequest
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.arghamnegargroup.core.features.order.domain.model.SuspendOrder

interface OrderRepository {

    suspend fun getSuspendOrders(): List<SuspendOrder>

    suspend fun suspendOrder(request: SuspendOrderRequest): String?

    suspend fun resumeSuspendOrder(request: ResumeSuspendOrderRequest): Order

}