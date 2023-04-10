package com.arghamnegargroup.core.features.order.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.order.data.dto.request.ResumeSuspendOrderRequest
import com.arghamnegargroup.core.features.order.data.dto.request.SuspendOrderRequest
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.arghamnegargroup.core.features.order.domain.model.SuspendOrder
import com.arghamnegargroup.core.features.order.domain.repository.OrderRepository
import java.lang.Exception

class OrderRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : OrderRepository {

    override suspend fun getSuspendOrders(): List<SuspendOrder> {
        return api.getSuspendOrders(connectionRepository.getUrl(Endpoints.GET_SUSPEND_ORDERS)).getSuspendOrders()
            ?: emptyList()
    }

    override suspend fun suspendOrder(request: SuspendOrderRequest): String? {
        val response = api.suspendOrder(connectionRepository.getUrl(Endpoints.SUSPEND_ORDER), request).result
        return response?.message
    }

    override suspend fun resumeSuspendOrder(request: ResumeSuspendOrderRequest): Order {
        return api.resumeSuspendOrder(connectionRepository.getUrl(Endpoints.RESUME_SUSPEND_ORDERS), request).result
            ?: throw Exception("سفارش یافت نشد.")
    }
}