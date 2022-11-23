package com.arghamnegargroup.core.features.order.domain.usecase

data class OrderUseCase(
    val getSuspendOrders: GetSuspendOrders,
    val resumeSuspendOrder: ResumeSuspendOrder,
    val suspendOrder: SuspendOrder,
)
