package com.arghamnegargroup.core.features.customer.data.dto.request

data class UseCreditRequest(
    val customerId: String,
    val groupId: String? = null,
    val amount: Double,
    val point: Double? = null,
    val description: String? = null,
    val storeId: Int? = null,
    val workStationId: Int? = null,
    val invoiceId: String? = null
)